package com.ayoub.barquitos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TableLayout tableLayout = findViewById(R.id.tableLayout);
        createTable(tableLayout);
    }

    private void createTable(TableLayout tableLayout) {
        for (int row = 1; row <= 10; row++) {
            TableRow tableRow = new TableRow(this);
            for (char colChar = 'A'; colChar <= 'J'; colChar++) {
                String buttonText = colChar + String.valueOf(row);
                Button button = new Button(this);
                button.setText(buttonText);
                button.setOnClickListener(v -> {
                    Toast.makeText(MainActivity.this, "Has pulsado " + buttonText, Toast.LENGTH_SHORT).show();
                });
                tableRow.addView(button);
            }
            tableLayout.addView(tableRow);
        }
    }
}