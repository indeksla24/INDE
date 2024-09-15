package com.inde;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class REAL_VIEW_3D_ENVIOURNMENT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_real_view_3d_enviournment);

    }
}

//filamentView = findViewById(R.id.filament_View);
//startRendering();
//    }
//
//private void startRendering() {
//    final android.os.Handler handler = new android.os.Handler();
//    Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            filamentView.render();
//            handler.postDelayed(this, 16);
//            filamentView.startRendering();
//        }
//
//    };
//    handler.post(remderRunnable);
//}































//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}