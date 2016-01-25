package com.brianmk.backcountrycheck_in;

/**
 * Created by rot on 2016-01-24.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {
    private static final String LOG_TAG = DrawerAdapter.class.getSimpleName();

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private String mNavTitles[];
    private int mIcons[];

    private String name;
    private int profile;
    private String email;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static final String LOG_TAG = ViewHolder.class.getSimpleName();

        int Holderid;

        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView Name;
        TextView email;

        public ViewHolder(View itemView,int ViewType) {
            super(itemView);

            if (ViewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.drawer_row_text);
                imageView = (ImageView) itemView.findViewById(R.id.drawer_row_icon);
                Holderid = 1;
            } else{
                Name = (TextView) itemView.findViewById(R.id.drawer_user_name);
                email = (TextView) itemView.findViewById(R.id.drawer_user_email);
                profile = (ImageView) itemView.findViewById(R.id.drawer_user_image);
                Holderid = 0;
            }
        }

    }

    DrawerAdapter(String Titles[],int Icons[],String Name,String Email, int Profile){
        mNavTitles = Titles;
        mIcons = Icons;
        name = Name;
        email = Email;
        profile = Profile;
    }

    @Override
    public DrawerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_row,parent,
                                                                        false);
            return (new ViewHolder(v, viewType));
        } else if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_header,
                                                                        parent,false);
            return (new ViewHolder(v, viewType));
        }
        return null;

    }

    @Override
    public void onBindViewHolder(DrawerAdapter.ViewHolder holder, int position) {
        if (holder.Holderid == 1) {
            holder.textView.setText(mNavTitles[position - 1]);
            holder.imageView.setImageResource(mIcons[position -1]);
        } else {
            holder.profile.setImageResource(profile);
            holder.Name.setText(name);
            holder.email.setText(email);
        }
    }

    @Override
    public int getItemCount() {
        return mNavTitles.length + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

}