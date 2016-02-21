package com.example.fragmentarticle;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;


public class MainActivity extends FragmentActivity 
	implements  HeadlinesFragment.mHeadlineSelectedListner{

	@Override
	protected void onCreate(Bundle savedinstaceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedinstaceState);
		setContentView(R.layout.news_article);
		
		if(findViewById(R.id.fragment_container)!=null){
			if(savedinstaceState !=null){
				return;
			}
			HeadlinesFragment firstFragment= new HeadlinesFragment();
			firstFragment.setArguments(getIntent().getExtras());
			getSupportFragmentManager().beginTransaction()
				.add(R.id.fragment_container, firstFragment).commit();
			
		}
	}

	@Override
	public void onArticleSelected(int position) {
		ArticleFragment articleFrag= (ArticleFragment)getSupportFragmentManager()
										.findFragmentById(R.id.article_fragment);
		if(articleFrag !=null){
			articleFrag.updateArticleView(position);
		}else{
			ArticleFragment newFragment=  new ArticleFragment();
			Bundle args= new Bundle();
			args.putInt(ArticleFragment.ARG_POSITION, position);
			newFragment.setArguments(args);
			FragmentTransaction txn= getSupportFragmentManager().beginTransaction();
			txn.replace(R.id.fragment_container, newFragment);
			txn.addToBackStack(null);
			txn.commit();
		}
	}


}
