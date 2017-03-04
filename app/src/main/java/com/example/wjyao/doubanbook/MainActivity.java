package com.example.wjyao.doubanbook;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("********" + DataLoader.loadData(this));
        final BookData bookData = new BookData(DataLoader.loadData(this));

        mListView = (ListView) findViewById(android.R.id.list);

        mListView.setAdapter(
            new ArrayAdapter<Book>(this, R.layout.list_item_book, bookData.getBooks()) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_book, parent, false);
                    final ImageView bookImage = (ImageView) view.findViewById(R.id.thumbnail);
                    TextView bookTitle = (TextView) view.findViewById(R.id.title);
                    TextView bookSummary = (TextView) view.findViewById(R.id.summary);
                    TextView bookInformation = (TextView) view.findViewById(R.id.information);
                    TextView ratingVal = (TextView) view.findViewById(R.id.ratingValue);
                    RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rating);

                    final Book book = getItem(position);
                    bookTitle.setText(book.getTitle());
                    bookSummary.setText(book.getSummary());
                    bookInformation.setText(book.getInformation());
                    ratingBar.setRating((float) (book.getRating() / 2));
                    ratingVal.setText(String.valueOf(book.getRating()));

                    new AsyncTask<Void, Void, Bitmap>() {
                        @Override
                        protected Bitmap doInBackground(Void... voids) {
                            return ImageLoader.loadImage(book.getImage());
                        }

                        @Override
                        protected void onPostExecute(Bitmap bitmap) {
                            super.onPostExecute(bitmap);
                            bookImage.setImageBitmap(bitmap);
                        }
                    }.execute();

                    return view;
                }
        });
    }
}
