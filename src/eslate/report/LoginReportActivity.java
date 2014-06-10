package eslate.report;

import eslate.main.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class LoginReportActivity extends Activity {

	EditText txtUsername;
	EditText txtPassword;

	@SuppressLint("NewApi")
	@Override
public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report_login);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		// To enable home button 
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

			// Init button of login GUI
			final Dialog login = new Dialog(this);
			login.setContentView(R.layout.login_dialog);
			Button btnLogin = (Button) login.findViewById(R.id.btnLogin);
			Button btnCancel = (Button) login.findViewById(R.id.btnCancel);
			final EditText txtUsername = (EditText)login.findViewById(R.id.txtUsername);
			final EditText txtPassword = (EditText)login.findViewById(R.id.txtPassword);
			txtUsername.setFocusable(true);

			// Attached listener for login GUI button
			btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			String name=txtUsername.getText().toString();
			String password=txtPassword.getText().toString();
					
			if(name.equals("admin") && password.equals("admin"))
			{		
				// Validate Your login credential here than display message
				Toast.makeText(LoginReportActivity.this,
				"Login Sucessfull", Toast.LENGTH_SHORT).show();login.dismiss();
				Intent intent=new Intent(LoginReportActivity.this, PreparationReport.class);
				startActivity(intent);
				finish();
			}
			// Redirect to dashboard / home screen.
			else
			{
				Toast.makeText(LoginReportActivity.this,"Please enter Username and Password", Toast.LENGTH_LONG).show();
				txtUsername.setText("");
				txtPassword.setText("");
				txtUsername.setFocusable(true);
					}
				}
			});
			
			btnCancel.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				login.dismiss();
				}
			});

		// Make dialog box visible.
		login.show();
	}
}