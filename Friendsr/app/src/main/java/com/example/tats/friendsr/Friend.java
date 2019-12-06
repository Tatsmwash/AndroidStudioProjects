package com.example.tats.friendsr;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;

import android.graphics.*;
import android.graphics.drawable.*;
import android.os.BatteryManager;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Environment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.*;
import android.view.MenuItem;
import android.view.View;
import android.net.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.*;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
//import android.net.*;
import java.io.File;
import android.provider.MediaStore;
public class Friend extends AppCompatActivity {


    public static final String TAG = "CallCamera";
    private static final int CAPTURE_IMAGE_ACTIVITY_REQ = 0;
    Uri photoUri;Bitmap bitmap;
    Uri fileUri = null;
    ImageView photoImage = null;
    EditText text;
    EditText text2;
    Button callCameraButton;
    Intent i;
    File file;
    File imageFile;
    BitmapDrawable drawable;
    File directory;
    String timeStamp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        photoImage=(ImageView) findViewById(R.id.photo_image);
        text = (EditText)findViewById(R.id.editText);
        text2 = (EditText)findViewById(R.id.editText2);
         callCameraButton = (Button)findViewById(R.id.button);
        callCameraButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                 i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                 file = getOutputPhotoFile();
                fileUri=Uri.fromFile(getOutputPhotoFile());
                i.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                startActivityForResult(i, CAPTURE_IMAGE_ACTIVITY_REQ); //returns photo file to activity when camera is done
                //ActivityResult(i,CAPTURE_IMAGE_ACTIVITY_REQ);
            }
            //store photo taken on SD card
            private File getOutputPhotoFile() {
                 directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),getPackageName());

                if (!directory.exists()){
                    if(!directory.mkdirs()){
                        Log.e(TAG,"Failed to create storage directory.");
                        return null;
                    }
                }

                //set photo name with standard time linked and store on sdCard in standard picture directory
                 timeStamp = new SimpleDateFormat("yyyMMdd_HHmmss",Locale.ENGLISH).format(new Date());

                return new File(directory.getPath() + File.separator + "IMG_"+timeStamp+".jpg");
            }

            //@Override
            protected void onActivityResult (int requestCode, int resultCode, Intent data){
               // super.onActivityResult(requestCode, resultCode, data);
                if (requestCode==CAPTURE_IMAGE_ACTIVITY_REQ){
                    if(resultCode==RESULT_OK){
                         photoUri = null;
                        if (data==null){


                            //confirming image save
                           Toast.makeText(getApplicationContext(),  "Image saved successfully",  Toast.LENGTH_LONG).show();
                            photoUri=fileUri;
                        } else {
                            photoUri = data.getData();
                            Toast.makeText(getApplicationContext(), "imaged saved successfully in: " + data.getData(), Toast.LENGTH_LONG).show();
                        }
                        photoUri = data.getData();
                        showPhoto(photoUri);

                    } else if (resultCode==RESULT_CANCELED) {
                       Toast.makeText(getApplicationContext(),"Cancelled", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Callout for image capture failed!", Toast.LENGTH_LONG).show();
                    }
                }
            }

        });


    }
    public void Submit(View view){


    }
    protected void showPhoto(Uri photoUri) {
        imageFile = new File(photoUri.getPath());
        if (imageFile.exists()){
            bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
            drawable = new BitmapDrawable(this.getResources(),bitmap);
            photoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);;
            photoImage.setImageDrawable(drawable);
            Drawable oldDrawable = photoImage.getDrawable();if(oldDrawable !=null) { ((BitmapDrawable)oldDrawable).getBitmap().recycle();
                Toast.makeText(getApplicationContext(), "not found", Toast.LENGTH_SHORT).show();
            }
        }


    }}