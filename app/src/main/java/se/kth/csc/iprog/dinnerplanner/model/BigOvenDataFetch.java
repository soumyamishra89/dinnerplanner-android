package se.kth.csc.iprog.dinnerplanner.model;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

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

/**
 * Created by SOMU on 01/03/16.
 */
public class BigOvenDataFetch extends AsyncTask<String, Void, List<Dish>> {

    DinnerModel dinnerModel;
    public BigOvenDataFetch(DinnerModel dinnerModel){
        this.dinnerModel = dinnerModel;
    }
    private final String LOG_TAG = BigOvenDataFetch.class.getName();
    public ProgressDialog mprogressdialog = null;
    @Override
    protected void onPreExecute(){
        mprogressdialog.show();
    }
    @Override
    protected void onPostExecute(List<Dish> dishes){
        dinnerModel.addNewDish(dishes);
        mprogressdialog.dismiss();
    }

    @Override
    protected List<Dish> doInBackground(String... params) {

        String bigOvenUrl = createBigOvenUri(params[0]);

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
            if(inputStream == null) {
                return null;
            }

            StringBuffer buffer = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line=reader.readLine()) != null) {
                buffer.append(line + "\n");
            }
            bigOvenData = buffer.toString();
            Log.v(LOG_TAG, bigOvenData);
            return extractDishes(bigOvenData);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if(httpURLConnection != null){
                httpURLConnection.disconnect();
            }
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e(LOG_TAG, "Error Closing Buffered Reader");
                }
            }
        }
        return new ArrayList<>();

    }

    private List<Dish> extractDishes(String bigOvenData) throws JSONException, IOException{
        if(bigOvenData.isEmpty()) {
            return null;
        }

        List<Dish> dishes = new ArrayList<>();
        JSONObject bigOvenResult = new JSONObject(bigOvenData);
        JSONArray bigOvenDishes = bigOvenResult.getJSONArray("Results");

        for (int i = 0; i<bigOvenDishes.length(); i++) {
            JSONObject bigOvenDish = bigOvenDishes.getJSONObject(i);
            Dish dish = new Dish(bigOvenDish.getString("Title"),
                    Dish.getDishType(bigOvenDish.getString("Category")),
                    loadImage(bigOvenDish.getString("ImageURL")), null,
                    bigOvenDish.getString("RecipeID"));

            dishes.add(dish);
        }

        return dishes;
    }

    private Bitmap loadImage(String imageURL) throws IOException{
        if(imageURL == null) {
            return null;
        }

        Bitmap mIcon11 = null;
        InputStream in =null;
        try {
            Log.v(LOG_TAG, imageURL);
            URL imageUrl = new URL(imageURL);
            in = imageUrl.openStream();
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(in, null, options);
            // Calculate inSampleSize
            options.inSampleSize = calculateInSampleSize(options,95,
                    90);
            // Decode bitmap with inSampleSize set
            options.inJustDecodeBounds = false;
            if(in.markSupported()) {
                in.reset();
            } else {
                in = new URL(imageURL).openStream();
            }
            mIcon11 = BitmapFactory.decodeStream(in,null, options);
            //mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        } finally {
            if(in != null) {
                in.close();
            }
        }
        return mIcon11;
    }

    public int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and
            // keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    String createBigOvenUri(String... params) {

        Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.scheme("http");
        uriBuilder.authority("api.bigoven.com");
        uriBuilder.appendPath("recipes");
        uriBuilder.appendQueryParameter("api_key", "18f3cT02U9f6yRl3OKDpP8NA537kxYKu");
        uriBuilder.appendQueryParameter("pg", "1");
        uriBuilder.appendQueryParameter("rpp", params[0]);
       //uriBuilder.appendQueryParameter("Accept", "application/json");
        return uriBuilder.toString();
    }
}
