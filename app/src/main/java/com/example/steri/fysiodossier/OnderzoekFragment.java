package com.example.steri.fysiodossier;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.ByteArrayOutputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class OnderzoekFragment extends Fragment {



    public OnderzoekFragment() {
        // Required empty public constructor
    }

//    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//    Fragment frag = this;
//    /** Pass your fragment reference **/
//       OnderzoekFragment.startActivityForResult(intent, REQUEST_IMAGE_CAPTURE); // REQUEST_IMAGE_CAPTURE = 12345
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == Activity.RESULT_OK) {
//            if (requestCode == REQUEST_IMAGE_CAPTURE) {
//                // Do something with imagePath
//
//                Bitmap photo = (Bitmap) data.getExtras().get("data");
//                imageview.setImageBitmap(photo);
//                // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
//                Uri selectedImage = getImageUri(getActivity(), photo);
//                String realPath=getRealPathFromURI(selectedImage);
//                selectedImage = Uri.parse(realPath);
//            }
//        }
//    }
////Method for getting Uri from the Bitmap
//    public Uri getImageUri(Context inContext, Bitmap inImage) {
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
//        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
//        return Uri.parse(path);
//    }
//
//    //Method for getting File path from the Uri
//
//    public String getRealPathFromURI(Uri contentUri) {
//        Cursor cursor = null;
//        try {
//            String[] proj = { MediaStore.Images.Media.DATA };
//            cursor = getActivity().getContentResolver().query(contentUri,  proj, null, null, null);
//            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            cursor.moveToFirst();
//            return cursor.getString(column_index);
//        } finally {
//            if (cursor != null) {
//                cursor.close();
//            }
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_onderzoek, container, false);





        return v;
    }

}
