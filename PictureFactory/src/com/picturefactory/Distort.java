/**
 * 
 * Distort类为用户列出了添加的装饰图案.
 * 本类通过BasicFunctionList类中的“图片扭曲”选项点击调用
 * 对应的布局文件名:distort_layout.xml
 * 通过选择不同的扭曲方案,用户可实现在图片的扭曲
 * 通过点击后退可以回到上一个画面
 * 通过点击返回可返回首页 
 * 
 * The code of this class is originally created by Zhou Xingyue.
 * 
 * Date: 2010/12/5
 * @author Zhou Xingyue
 *
 */
package com.picturefactory;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Distort extends Activity{
	private RadioGroup distortChoiceGroup;   
	private RadioButton style1 ;   
	private RadioButton style2;   
	private RadioButton style3;   
	int choice;

	@Override  
	public void onCreate(Bundle savedInstanceState) {   
		super.onCreate(savedInstanceState);   
		setContentView(R.layout.distort_layout);  
		
		distortChoiceGroup = (RadioGroup)findViewById(R.id.distort_choices);   
		style1= (RadioButton)findViewById(R.id.style1); 
		style2 = (RadioButton)findViewById(R.id.style2);
		style3= (RadioButton)findViewById(R.id.style3);
		
		distortChoiceGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {   

			@Override  
			public void onCheckedChanged(RadioGroup group, int checkedId) {   

				if(style1.getId() == checkedId){   
					choice=1;
					

				}   
				else if(style2.getId() == checkedId)   
				{   
					choice=2;
				}  
				else if(style3.getId() == checkedId)   
				{   
					choice=3;
				}  
			}   
		});  
		
		
		
		Button submit = (Button) this.findViewById(R.id.submit);
        
		

		submit.setOnClickListener(new OnClickListener(){
			                   		
			@Override
			public void onClick(View arg0){
				
				if(choice==1){
				
				Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);
				Bitmap distortBitmap = ImageProcessFunction.distort(bitmapOriginal,0.2f,0.2f);
				
		       
		        ShowResult.modifiedBitmap = distortBitmap;
					Intent i = new Intent(
							Distort.this,
							ShowResult.class);

					startActivity(i);
				}else if(choice==2){
					Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);
					
					Bitmap distortBitmap = ImageProcessFunction.distort(bitmapOriginal,0.3f,0.5f);
					
				       
			        ShowResult.modifiedBitmap = distortBitmap;
			       
			      
						Intent i = new Intent(
								Distort.this,
								ShowResult.class);

						startActivity(i);
				}else if(choice==3){
					Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(ChoosePicture.chosenPicture);
					
					Bitmap distortBitmap = ImageProcessFunction.distort(bitmapOriginal,-0.2f,-0.2f);
					
				       
			        ShowResult.modifiedBitmap = distortBitmap;
						Intent i = new Intent(
								Distort.this,
								ShowResult.class);

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
						Distort.this,
						BasicFunctionList.class);

				startActivity(i);

			}
		});
		
		
		//Create a button to go home view
		Button homeButton =(Button) this.findViewById(R.id.home_button);
		homeButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can go to the second screen to input data.
			@Override
			public void onClick(View arg0){
				Intent i = new Intent(
						Distort.this,
						WelcomeScreen.class);

				startActivity(i);

			}
		});
		
	}
	
	
	
}

