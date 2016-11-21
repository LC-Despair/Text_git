package com.example.android_text02;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button button = null;
	private TextView mysel = null;
	private TextView company = null;
	private TextView ceo = null;
	private TextView file = null;
	private int chNum = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.button = (Button) super.findViewById(R.id.sel);
		this.mysel = (TextView) super.findViewById(R.id.mysel);
		this.company = (TextView) super.findViewById(R.id.company);
		this.ceo = (TextView) super.findViewById(R.id.ceo);
		this.file = (TextView) super.findViewById(R.id.file);
		// 为我们的按钮添加点击事件
		this.button.setOnClickListener(new OnClickListenerImp());
	}

	public class OnClickListenerImp implements OnClickListener {

		public void onClick(View arg0) {
			// 创建我们的单选对话框
			Dialog dialog = new AlertDialog.Builder(MainActivity.this).setTitle("选择公司").setIcon(R.drawable.ic_launcher)
					.setPositiveButton("确定", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							MainActivity.this.mysel.setText(
									"您的选择是" + MainActivity.this.getResources().getStringArray(R.array.company)[chNum]);
						}
					}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
						}
					}).setSingleChoiceItems(R.array.company, 0, new DialogInterface.OnClickListener() {
						// 上边第一个表示的是公司数组列表，第二个参数表示默认选择的，第三个监听器
						public void onClick(DialogInterface dialog, int which) {
							chNum = which;
							MainActivity.this.company.setText(
									"公司:" + MainActivity.this.getResources().getStringArray(R.array.company)[which]);
							MainActivity.this.ceo.setText(
									"ceo:" + MainActivity.this.getResources().getStringArray(R.array.ceo)[which]);
							MainActivity.this.file.setText(
									"行业:" + MainActivity.this.getResources().getStringArray(R.array.file)[which]);
						}
					}).create();
			dialog.show();
		}
	}

}