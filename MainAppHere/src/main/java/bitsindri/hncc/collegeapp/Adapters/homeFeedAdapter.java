package bitsindri.hncc.collegeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.GetterAndSetter.feed;
import bitsindri.hncc.collegeapp.R;

public class homeFeedAdapter extends RecyclerView.Adapter{

    ArrayList<feed> homeFeedList;
    Context myContext;

    public homeFeedAdapter(ArrayList<feed> homeFeedList, Context myContext) {
        this.homeFeedList = homeFeedList;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_feed, parent, false);
        return new homeFeedAdapter.FeedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final FeedHolder FeedHolder = (FeedHolder)holder;

        final feed feed = homeFeedList.get(position);

        FeedHolder.feedProfileName.setText(feed.getProfileName());
        FeedHolder.feedDateAndTime.setText(feed.getPostDateAndTime());

        String PostImageUrl = feed.getPostImageUrl();
        if(!PostImageUrl.equals("no_post_img")){
            FeedHolder.feedImage.setImageResource(R.drawable.desktop);
        }else {
            FeedHolder.feedImage.setVisibility(View.GONE);
        }

        FeedHolder.feedText.setText(feed.getPostMessage());

        FeedHolder.feedLikes.setText(feed.getPostLikes()+" Likes");

    }

    @Override
    public int getItemCount() {
        return homeFeedList == null? 0: homeFeedList.size();
    }

    public class FeedHolder extends RecyclerView.ViewHolder {

        TextView feedProfileName;
        TextView feedDateAndTime;
        ImageView feedImage;
        TextView feedText;
        TextView feedLikes;

        public FeedHolder(View itemView) {
            super(itemView);
            feedProfileName = itemView.findViewById(R.id.each_post_name_text_view);
            feedDateAndTime= itemView.findViewById(R.id.each_post_date_and_time_text_view);
            feedImage = itemView.findViewById(R.id.feed_image);
            feedText = itemView.findViewById(R.id.feed_text);
            feedLikes = itemView.findViewById(R.id.feed_likes);
        }

    }

}
