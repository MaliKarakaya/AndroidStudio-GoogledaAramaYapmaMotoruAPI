package com.mali.googlearama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Arama öğesi nesnesini oluşturun
        searchView = findViewById(R.id.search_view);

        // Arama sorgusu oluşturun
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Kullanıcı sorguyu girdikten sonra yapılacak işlemler
                searchOnGoogle(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Kullanıcı sorgu içeriğini değiştirirken yapılacak işlemler
                return false;
            }
        });
    }

    private void searchOnGoogle(String query) {
        // Google aramasını gerçekleştirin
        String googleSearchUrl = "https://www.google.com/search?q=" + query;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleSearchUrl));
        startActivity(intent);
    }
}
