package adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pruebas.elsve.materialdesignexamplesrecyclerview.R;

import java.util.List;

import model.Landscape;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private static final int SPECIAL_ROW = 0;
    private static final int NO_SPECIAL_ROW = 1;

    private List<Landscape> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context,List<Landscape> data){
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.list_item, parent, false);
//        MyViewHolder holder = new MyViewHolder(view);
//        return holder;

        switch (viewType){
            case SPECIAL_ROW:

                ViewGroup primeRow = (ViewGroup) mInflater.inflate(R.layout.list_item, parent, false);
                MyViewHolder_SPECIAL holderSpecial = new MyViewHolder_SPECIAL(primeRow);
                return holderSpecial;
            case NO_SPECIAL_ROW:
                ViewGroup noSpecial = (ViewGroup) mInflater.inflate(R.layout.list_item_not_prime, parent, false);
                MyViewHolder_No_SPECIAL holderNoSpecial = new MyViewHolder_No_SPECIAL(noSpecial);
                return holderNoSpecial;
            default:
                ViewGroup defaultRow = (ViewGroup) mInflater.inflate(R.layout.list_item, parent, false);
                MyViewHolder_No_SPECIAL holderDefault = new MyViewHolder_No_SPECIAL(defaultRow);
                return holderDefault;
        }

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

//        Landscape current = mData.get(position);
        Landscape current = mData.get(position);

        switch (holder.getItemViewType()){
            case SPECIAL_ROW:
                MyViewHolder_SPECIAL holderSpecial = (MyViewHolder_SPECIAL) holder;
                holderSpecial.setData(current);
                break;

            case NO_SPECIAL_ROW:
                MyViewHolder_No_SPECIAL holderNoSpecial = (MyViewHolder_No_SPECIAL) holder;
                holderNoSpecial.setData(current);
                break;
        }

//        holder.setData(current, position);
        //holder.setListeners();

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {

        Landscape landscape = mData.get(position);
        if(landscape.isSpecial())
            return SPECIAL_ROW;
        else
            return NO_SPECIAL_ROW;

    }

    public void removeItem(int position){
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mData.size());
    }

    public void addItem(int position, Landscape landscape){
        mData.add(position, landscape);
//        notifyItemInserted(position);
//        notifyItemRangeChanged(position, mData.size());
        notifyDataSetChanged();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView imgThumb, imgDelete, imgAdd;
        int position;
        Landscape current;

        public MyViewHolder(View itemView) {
            super(itemView);
               title = (TextView) itemView.findViewById(R.id.tvTitle);
               imgThumb = (ImageView) itemView.findViewById(R.id.imgRow);
               imgDelete = (ImageView) itemView.findViewById(R.id.img_row_delete);
               imgAdd = (ImageView) itemView.findViewById(R.id.img_row_copy);

        }



//        public void setData(Landscape current, int position) {
//            this.title.setText(current.getTitle());
//            this.imgThumb.setImageResource(current.getImageID());
//            this.position = position;
//            this.current = current;
//
//        }
//
//        public void setListeners(){
//            imgDelete.setOnClickListener(MyViewHolder.this);
//            imgAdd.setOnClickListener(MyViewHolder.this);
//        }

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.img_row_delete:
                    removeItem(position);
                    break;
                case R.id.img_row_copy:
                    addItem(position, current);
                    break;
            }
        }
    }

    public class MyViewHolder_SPECIAL extends MyViewHolder{

        TextView title;
        ImageView imgThumb, img_add, img_delete;

        public MyViewHolder_SPECIAL(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.img_icono);
            img_add = (ImageView) itemView.findViewById(R.id.img_row_copy);
            img_delete = (ImageView) itemView.findViewById(R.id.img_row_delete);

        }

        public void setData(Landscape current){

            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
        }

    }





    public class MyViewHolder_No_SPECIAL extends MyViewHolder{

        TextView title;
        ImageView imgThumb, imgAdd, imgDelete;

        public MyViewHolder_No_SPECIAL(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.img_icono);
            imgAdd = (ImageView) itemView.findViewById(R.id.img_row_copy);
            imgDelete = (ImageView) itemView.findViewById(R.id.img_row_delete);

        }

        public void setData(Landscape current){
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
        }

    }

}
