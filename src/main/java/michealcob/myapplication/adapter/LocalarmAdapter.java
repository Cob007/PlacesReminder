package michealcob.myapplication.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import michealcob.myapplication.R;
import michealcob.myapplication.model.Localarm;

/**
 * Created by michealcob on 1/8/18.
 */

public class LocalarmAdapter extends RecyclerView.Adapter<LocalarmAdapter.ViewHolder> {

    List<Localarm> localarmList;
    Context context;


    public LocalarmAdapter(Context _context, List<Localarm> _localarmList){
        this.context = _context;
        this.localarmList = _localarmList;
    }

    DatabaseHandler db = new DatabaseHandler(context);

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //text from the textView
        //holder.text.setText(mPostFeeds.get(position).getUser());
        Localarm localarm = localarmList.get(position);
        ViewHolder viewHolder = holder;
        viewHolder.mTitle.setText(localarm.getTitle());
        viewHolder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete(position);
            }
        });
        viewHolder.mLat.setText(localarm.getMyDestinationLat());
        viewHolder.mLong.setText(localarm.getMyDestinationLng());
    }

    private void Delete(int position) {
        /*Localarm l = localarmList.get(position);
        db.deleteTask(l);*/
        localarmList.remove(position);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        if (null == localarmList) return 0;
        return this.localarmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public ImageView mDelete;
        public TextView mLong;
        public TextView mLat;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_title);
            mDelete = itemView.findViewById(R.id.delete);
            mLat = itemView.findViewById(R.id.latitude);
            mLong = itemView.findViewById(R.id.longitude);
        }
    }
}
