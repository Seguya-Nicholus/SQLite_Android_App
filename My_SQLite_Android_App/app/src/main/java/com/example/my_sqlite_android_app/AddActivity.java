package com.example.my_sqlite_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText bookTitle, bookAuthor, bookPages;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        bookTitle = findViewById(R.id.book_title);
        bookAuthor = findViewById(R.id.book_author);
        bookPages = findViewById(R.id.book_pages);

        addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDatabaseHelper myDb = new MyDatabaseHelper(AddActivity.this);
                myDb.addBook(bookTitle.getText().toString().trim(),bookAuthor.getText().toString().trim(),Integer.valueOf(bookPages.getText().toString().trim()));

                bookTitle.setText("");
                bookAuthor.setText("");
                bookPages.setText("");
            }
        });
    }
}