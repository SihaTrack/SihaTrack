package com.eniad.sihatrack_v_1.ui.userActivities.articles;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eniad.sihatrack_v_1.R;

import java.io.IOException;
import java.io.InputStream;

public class ArticlDetailsFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_PARAGRAPH = "paragraph";
    private static final String ARG_IMAGE = "image";
    private static final String ARG_CONTENU = "contenu";
    private static final String ARG_URL = "url";

    public ArticlDetailsFragment() {
        // Required empty public constructor
    }

    public static ArticlDetailsFragment newInstance(String title, String image,String paragraph,String contenu,String url) {
        ArticlDetailsFragment fragment = new ArticlDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_IMAGE, image);
        args.putString(ARG_PARAGRAPH, paragraph);
        args.putString(ARG_CONTENU, contenu);
        args.putString(ARG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articl_details, container, false);
        TextView titleTextView = view.findViewById(R.id.detailTitle);
        TextView paragraphTextView = view.findViewById(R.id.detailParagraph);
        TextView contenuTextView = view.findViewById(R.id.detailContenu);
        TextView urlTextView = view.findViewById(R.id.detailUrl);
        ImageView imageView = view.findViewById(R.id.detailImage);

        if (getArguments() != null) {
            titleTextView.setText(getArguments().getString(ARG_TITLE));
            paragraphTextView.setText(getArguments().getString(ARG_PARAGRAPH));
            contenuTextView.setText(getArguments().getString(ARG_CONTENU));
            String url = getArguments().getString(ARG_URL);

            urlTextView.setText(url);
            urlTextView.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            });

            try {
                InputStream inputStream = requireContext().getAssets().open(getArguments().getString(ARG_IMAGE));
                imageView.setImageBitmap(BitmapFactory.decodeStream(inputStream));
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return view;
    }
}