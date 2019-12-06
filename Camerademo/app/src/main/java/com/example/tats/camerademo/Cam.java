package com.example.tats.camerademo;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.*;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Cam extends Activity {
    public static final String EXTRA_NAME = "com.example.tats.name";
    public static final String EXTRA_EMAIL = "com.example.tats.number";
    //public static final String EXTRA_IMAGE="com.example.tats.image";
    ImageView viewImage;
    Button b;
    EditText text;
    EditText text2;
    Button sub;
    File f;
    Bitmap bitmap;
    ByteArrayOutputStream baos;
    Drawable drawable;
    String path;
    byte[] bt;
    BitmapFactory.Options bitmapOptions ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        b=(Button)findViewById(R.id.btnSelectPhoto);
        sub=(Button)findViewById(R.id.button);
        viewImage=(ImageView)findViewById(R.id.viewImage);
        text = (EditText)findViewById(R.id.editText);
        text2 = (EditText)findViewById(R.id.editText2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
    }


    private void selectImage() {

        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(Cam.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                }
                else if (options[item].equals("Choose from Gallery"))
                {
                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);

                }
                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                 f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {

                     bitmapOptions = new BitmapFactory.Options();
                     baos = new ByteArrayOutputStream();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(), bitmapOptions);

                    viewImage.setImageBitmap(bitmap);

                     path = android.os.Environment.getExternalStorageDirectory() + File.separator + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        bt = baos.toByteArray();
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {

                Uri selectedImage = data.getData();
                String[] filePath = { MediaStore.Images.Media.DATA };
                Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                Log.w("path of image from gallery......******************.........", picturePath+"");
                viewImage.setImageBitmap(thumbnail);
            }
        }
    }
    public void Submit(View v){
        Intent i = new Intent(Cam.this, MainActivity.class);
       // ByteArrayOutputStream bs = new ByteArrayOutputStream();
        viewImage=(ImageView)findViewById(R.id.viewImage);
        bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(), bitmapOptions);

        viewImage.setImageBitmap(bitmap);
        text= (EditText)findViewById(R.id.editText);
        text2 = (EditText)findViewById(R.id.editText2);
        String ETName = text.getText().toString();
        String ETEmail = text2.getText().toString();
       // i.putExtra("picture", bt);
        i.putExtra(EXTRA_NAME, ETName);
        i.putExtra(EXTRA_EMAIL, ETEmail);
        //i.putExtra("USE_A_CONSTANT_HERE_AS_KEY", R.drawable.imag);

        i.putExtra("imagePath", path);

        startActivity(i);

    }

}