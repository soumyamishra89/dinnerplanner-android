package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

/**
 * Created by Adnan Sakel on 2/13/2016.
 */
public class ItemPriceDialogView {
    View view;
    TextView txtDishName;
    TextView txtDishCost;
    TextView txtTotalDishCost;

    ImageView imgDish;
    Context mycontext;
    Button btnChoose;

    ProgressDialog progress;
    public ItemPriceDialogView(final View view, Dish dish, Integer noOfGuests, Context mycontext){
        this.view = view;

        txtDishName = (TextView) view.findViewById(R.id.txtDishName);
        txtDishCost = (TextView) view.findViewById(R.id.txtDishCost);
        txtTotalDishCost = (TextView) view.findViewById(R.id.txttotalDishCost);

        imgDish = (ImageView) view.findViewById(R.id.imgDish);
        this.mycontext = mycontext;


        if (dish.getIngredients().isEmpty()) {
            IngredientFetchAsyncTask ingredientFetchAsyncTask = new IngredientFetchAsyncTask(dish, noOfGuests);
            ingredientFetchAsyncTask.execute();
        }
    }

    public class IngredientFetchAsyncTask extends AsyncTask<String, Void, List<Ingredient>> {

        private final String LOG_TAG = IngredientFetchAsyncTask.class.getName();

        Dish selectedDish;
        Integer noOfGuests;

        public IngredientFetchAsyncTask(Dish dish, Integer noOfGuests){
            selectedDish = dish;
            this.noOfGuests = noOfGuests;
        }

        @Override
        protected List<Ingredient> doInBackground(String... params){

            String bigOvenUrl = createBigOvenUri();

            HttpURLConnection httpURLConnection = null;
            BufferedReader reader = null;
            String bigOvenData = null;
            try {
                URL url = new URL(bigOvenUrl);

                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("Accept", "application/json");
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream == null) {
                    return null;
                }

                StringBuffer buffer = new StringBuffer();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while (( line = reader.readLine() ) != null) {
                    buffer.append(line + "\n");
                }
                bigOvenData = buffer.toString();
                Log.v(LOG_TAG, bigOvenData);
                return extractIngredients(bigOvenData);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        Log.e(LOG_TAG, "Error Closing Buffered Reader");
                    }
                }
            }
            return new ArrayList<>();

        }

        private List<Ingredient> extractIngredients(String bigOvenData) throws JSONException{
            if (bigOvenData == null) {
                return null;
            }
            List<Ingredient> ingredients = new ArrayList<>();
            JSONObject bigOvenResult = new JSONObject(bigOvenData);

            selectedDish.setDescription(bigOvenResult.getString("Instructions"));

            JSONArray bigOvenIngredients = bigOvenResult.getJSONArray("Ingredients");
            for (int i = 0; i < bigOvenIngredients.length(); i++) {
                JSONObject bigOvenIngredient = bigOvenIngredients.getJSONObject(i);
                Ingredient ingredient = new Ingredient(bigOvenIngredient.getString("Name"),
                        bigOvenIngredient.getString("Quantity"),
                        bigOvenIngredient.getString("Unit"),
                        bigOvenIngredient.getDouble("Quantity"));

                ingredients.add(ingredient);
            }

            return ingredients;
        }

        String createBigOvenUri(String... params){

            Uri.Builder uriBuilder = new Uri.Builder();
            uriBuilder.scheme("http");
            uriBuilder.authority("api.bigoven.com");
            uriBuilder.appendPath("recipe");
            uriBuilder.appendPath(selectedDish.getRecipeId());
            uriBuilder.appendQueryParameter("api_key", "XKEdN82lQn8x6Y5jm3K1ZX8L895WUoXN");
            return uriBuilder.toString();
        }

        @Override protected void onPreExecute(){
            progress = new ProgressDialog(mycontext);
            progress.setMessage("Loading...");
            progress.show();
        }
        @Override
        protected void onPostExecute(List<Ingredient> ingredients){
            if (!ingredients.isEmpty()) {
                float price = 0;
                for (Ingredient ingredient : ingredients) {
                    selectedDish.addIngredient(ingredient);
                    price += ingredient.getPrice();
                }

                txtDishName.setText(selectedDish.getName());
                txtDishCost.setText(price + " Kr / Person");
                txtTotalDishCost.setText("Cost: " + price * noOfGuests + " Kr");

                imgDish.setImageBitmap(selectedDish.getImage());
                progress.dismiss();
            }
        }
    }
}