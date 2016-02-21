package com.example.fragmentarticle;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HeadlinesFragment extends ListFragment {

	mHeadlineSelectedListner mCallback;
	
	public interface mHeadlineSelectedListner{
		public void onArticleSelected(int position);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int layout = android.R.layout.simple_list_item_1;
		setListAdapter(new ArrayAdapter<String>(getActivity(), layout, ArticleData.Headlines ));
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try{
			mCallback= (mHeadlineSelectedListner) activity ;
		}
		catch(ClassCastException e){
			throw new ClassCastException(activity.toString()+
					" Should implement mHeadlineSelectedListner");
		}
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		if(getFragmentManager().findFragmentById(R.id.article_fragment)!=null){
			getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		}
		
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		  mCallback.onArticleSelected(position);
		  getListView().setItemChecked(position,true);
	}
	
}
