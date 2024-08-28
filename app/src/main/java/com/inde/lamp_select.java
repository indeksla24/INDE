package com.inde;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class lamp_select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lamp_select);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //        AR INTEGRATION WITH BUTTONS
    public void chair1_buttonARView(View view) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://raw.githubusercontent.com/indeksla24/inde_3d_models/main/LAMP%201.gltf"));
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }
    public void bed2_buttonARView(View view) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://raw.githubusercontent.com/indeksla24/inde_3d_models/main/LAMP%202.gltf"));
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }
    public void bed3_buttonARView(View view) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://raw.githubusercontent.com/indeksla24/inde_3d_models/main/LAMP%203.gltf"));
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }
    public void bed4_buttonARView(View view) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://raw.githubusercontent.com/indeksla24/inde_3d_models/main/LAMP%204.gltf"));
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }
    public void bed5_buttonARView(View view) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://raw.githubusercontent.com/indeksla24/inde_3d_models/main/LAMP%205.gltf"));
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }
    public void bed6_buttonARView(View view) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        sceneViewerIntent.setData(Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://raw.githubusercontent.com/indeksla24/inde_3d_models/main/LAMP%205.gltf"));
        sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox");
        startActivity(sceneViewerIntent);
    }

}