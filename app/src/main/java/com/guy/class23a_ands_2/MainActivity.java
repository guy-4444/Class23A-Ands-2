package com.guy.class23a_ands_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private AppCompatImageView imageView1;
    private AppCompatImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);

        Benchmark benchmark = new Benchmark();



        benchmark.newRecord("getBitmapFromImageRes");
        Bitmap bitmap1 = getBitmapFromImageRes(R.drawable.img_plane);
        imageView1.setImageBitmap(bitmap1);

        benchmark.done();

        benchmark.newRecord("getBase64FromBitmap");
        String base64 = getBase64FromBitmap(bitmap1);
        benchmark.done();

        benchmark.newRecord("encryptString");
        String encrypted = encryptString(base64);
        benchmark.done();
        // upload

        // download
        benchmark.newRecord("decryptString");
        String decryptedBase64 = decryptString(encrypted);
        benchmark.done();

        benchmark.newRecord("decodeBase64");
        Bitmap bitmap2 = decodeBase64(decryptedBase64);
        benchmark.done();

        imageView2.setImageBitmap(bitmap2);


        Log.d("pttt", benchmark.getLog());
    }

    public static Bitmap decodeBase64(String base64) {
        byte[] decodedBytes = Base64.decode(base64,0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

    private String decryptString(String str) {
        // TODO: 14/11/2022 Decryption function
        return str;
    }

    private String encryptString(String str) {
        // TODO: 14/11/2022 Encryption Function
        return str;
    }

    private Bitmap getBitmapFromImageRes(int res) {
        return BitmapFactory.decodeResource(getResources(), res);
    }

    private String getBase64FromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteStream);
        byte[] byteArray = byteStream.toByteArray();
        String baseString = Base64.encodeToString(byteArray,Base64.DEFAULT);
        return baseString;
    }

}









