package com.example.fragmentarticle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {

	public static final String ARG_POSITION= "position";
	int mCurrentPosition = -1 ;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		if(savedInstanceState!=null){
			mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
		}
		return inflater.inflate(R.layout.article_view, container,false);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt(ARG_POSITION, mCurrentPosition);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Bundle args= getArguments();
		
		if(args!=null){
			updateArticleView(args.getInt(ARG_POSITION));
		}else if(mCurrentPosition!=-1){
			updateArticleView(mCurrentPosition);
		}
		else{
			updateArticleView(0);
			mCurrentPosition=0;
		}
	}
	
	public void updateArticleView(int position){
	
		TextView article_view = (TextView)getActivity().findViewById(R.id.article);
		article_view.setText(ArticleData.Articles[position]);
		mCurrentPosition= position ;
	}
}
