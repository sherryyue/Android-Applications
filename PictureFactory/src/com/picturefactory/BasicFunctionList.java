package com.picturefactory;
/**
 * BasicFunction类为用户列出所有基本图片处理功能(不需网络连接以及server端程序的开启).
 * 本类通过ChooseProcessingLevel类中的“基本功能”按钮点击调用
 * 对应的布局文件名:basic_function_list_layout.xml
 * 通过选择相应功能,用户可实现对图片的处理
 * 通过点击返回可以回到上一个画面
 *  
 * The code of this class is originally created by Zhou Xingyue.
 * 
 * Date: 2010/12/5
 * @author Zhou Xingyue
 *
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;



public class BasicFunctionList extends Activity{

	private RadioGroup basicFunctionGroup;   
	private RadioButton addIconRadio ;   
	private RadioButton resizeRadio;   
	private RadioButton reflectionRadio;   
	private RadioButton distortRadio;   
	private RadioButton pruneRadio;   
	public static String userChoice;
	@Override  
	public void onCreate(Bundle savedInstanceState) {   
		super.onCreate(savedInstanceState);   
		setContentView(R.layout.basic_function_list_layout);  

		basicFunctionGroup = (RadioGroup)findViewById(R.id.basic_function_group);   
		addIconRadio= (RadioButton)findViewById(R.id.add_icon); 
		resizeRadio = (RadioButton)findViewById(R.id.resize);   
		reflectionRadio = (RadioButton)findViewById(R.id.reflection);  
		distortRadio = (RadioButton)findViewById(R.id.distort); 
		pruneRadio = (RadioButton)findViewById(R.id.prune);

		basicFunctionGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {   

			@Override  
			public void onCheckedChanged(RadioGroup group, int checkedId) {   

				if(addIconRadio.getId() == checkedId){   
					userChoice = "addIcon";


				}   
				else if(resizeRadio.getId() == checkedId)   
				{   
					userChoice = "resize";
				}  
				else if(reflectionRadio.getId() == checkedId)   
				{   
					userChoice = "reflection"; 
				}   
				else if(distortRadio.getId() == checkedId)   
				{   
					userChoice = "distort";  
				}   
				else if(pruneRadio.getId() == checkedId)   
				{   
					userChoice = "prune";  
				}   

			}   
		});   

		Button submitButton =(Button) this.findViewById(R.id.submit);
		submitButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can go to the second screen to input data.
			@Override
			public void onClick(View arg0){
				if(userChoice =="addIcon"){   
					Intent i = new Intent(
							BasicFunctionList.this,
							AddIcon.class);

					startActivity(i);

				}   
				else if(userChoice == "resize")   
				{   
					Intent i = new Intent(
							BasicFunctionList.this,
							Resize.class);

					startActivity(i);
				}  
				else if(userChoice == "reflection")   
				{   
					Intent i = new Intent(
							BasicFunctionList.this,
							Reflection.class);

					startActivity(i); 
				}   
				else if(userChoice == "distort")   
				{   
					Intent i = new Intent(
							BasicFunctionList.this,
							Distort.class);

					startActivity(i); 
				}   
				else if(userChoice == "prune")   
				{   
					Intent i = new Intent(
							BasicFunctionList.this,
							Prune.class);

					startActivity(i); 
				}   

			}   

		});

		//Create a button to go back to the previous view
		Button backButton =(Button) this.findViewById(R.id.back_button);
		backButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can go to the second screen to input data.
			@Override
			public void onClick(View arg0){
				Intent i = new Intent(
						BasicFunctionList.this,
						WelcomeScreen.class);

				startActivity(i);

			}
		});

		
		Button changePictureButton =(Button) this.findViewById(R.id.change_pic_button);
		changePictureButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can go to the second screen to input data.
			@Override
			public void onClick(View arg0){
				Intent i = new Intent(
						BasicFunctionList.this,
						ChoosePicture.class);

				startActivity(i);

			}
		});

	}


}
