package hung.vo.hung.vo;

import hung.vo.PlaceRequest;
import hung.vo.R;
import hung.vo.R.layout;
import hung.vo.model.Place;
import hung.vo.model.PlacesList;
import android.R.string;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class GooglePlaceActivity extends Activity {
    /** Called when the activity is first created. */
	Button btn1;
	TextView txt1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.main);
        btn1 = (Button)findViewById(R.id.button1);
        txt1 = (TextView)findViewById(R.id.textView1);
        btn1.setOnClickListener(l);        
		
    }
    
    private class SearchSrv extends AsyncTask<Void, Void, PlacesList>{
    	@Override
    	protected PlacesList doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		PlacesList pl = null;
    		try {
    			 pl = new PlaceRequest().performSearch();
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return pl;
    	}
    	
    	@Override
    	protected void onPostExecute(PlacesList result) {
    		// TODO Auto-generated method stub
    		String text = "Result \n";
			
	        
			if (result!=null){
				for(Place place: result.results){
					text = text + place.name +"\n";
				}
				txt1.setText(text);
			}
			setProgressBarIndeterminateVisibility(false);
    	}
    }
    
    View.OnClickListener l = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			SearchSrv srv = new SearchSrv();
			setProgressBarIndeterminateVisibility(true);
			srv.execute();			
			
		}
	};
	
	
}

