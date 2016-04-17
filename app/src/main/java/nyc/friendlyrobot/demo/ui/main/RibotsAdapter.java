package nyc.friendlyrobot.demo.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import nyc.friendlyrobot.demo.androidboilerplate.R;
import nyc.friendlyrobot.demo.data.model.RedditData;

public class RibotsAdapter extends RecyclerView.Adapter<RibotsAdapter.RibotViewHolder> {

//    private List<Loo> data;

    @Inject
    public RibotsAdapter() {
//        data = new ArrayList<>();
    }

    public void setLoos(List<RedditData> looList) {
//        data = looList;
    }

    @Override
    public RibotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ribot, parent, false);
        return new RibotViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RibotViewHolder holder, int position) {
//            holder.nameTextView.setText(data.get(position).id()+"");
//            holder.emailTextView.setText(data.get(position).foo_id()+"");
    }

    @Override
    public int getItemCount() {
        return 0;
//        return data.size();
    }

    class RibotViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.view_hex_color) View hexColorView;
        @Bind(R.id.text_name) TextView nameTextView;
        @Bind(R.id.text_email) TextView emailTextView;

        public RibotViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
