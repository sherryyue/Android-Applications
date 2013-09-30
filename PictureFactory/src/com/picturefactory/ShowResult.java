/**
 * ShowResult类用于为用户显示经基本功能加工后的图片,并且可以将处理后的图片直接设置为新墙纸
 * 本类通过 AddIcon.java,Distort.java,Prune.java,Reflection.java,Resize.java这5个基本处理功能的类调用
 * 通过点击“设置为墙纸”按钮可以将处理后的图片直接设置为新墙纸
 * 对应的布局文件名:show_result_layout.xml
 *
 * The code of this class is originally created by Zhou Xingyue.
 * 
 * Date: 2010/12/5
 * @author Zhou Xingyue
 *
 */
package com.picturefactory;


import java.io.IOException;

import android.app.Activity;   
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;   
import android.graphics.drawable.Drawable;   
import android.os.Bundle;   
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;   
import android.widget.Toast;
public class ShowResult extends Activity {   
	private ImageView originalView,modifiedView;   

	public static Bitmap modifiedBitmap;
	public void onCreate(Bundle savedInstanceState) {   
		super.onCreate(savedInstanceState);   
		setContentView(R.layout.show_result_layout);   
		showResult();   

		//Create a button to set the edited picture as new wallpaper
		Button setWallpaperButton =(Button) this.findViewById(R.id.set_wallpaper_button);
		setWallpaperButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can  set the edited picture as new wallpaper
			@Override
			public void onClick(View arg0){
				Bitmap newWallpaper;
				newWallpaper=modifiedBitmap;
				//adjust size of your edited picture to fit the screen
				//get screen height and width
				int newWallpaperWidth,newWallpaperHeight;     
				WindowManager windowManager2 = getWindowManager();     
				Display display2 = windowManager2.getDefaultDisplay();     
				newWallpaperWidth = display2.getWidth();     
				newWallpaperHeight = display2.getHeight(); 
				int modifiedPictureOrignalWidth,modifiedPictureOrignalHeight; 

				modifiedPictureOrignalWidth=modifiedBitmap.getWidth();
				modifiedPictureOrignalHeight=modifiedBitmap.getHeight();

				//adjust the width and height proportionate to the original size 
				if(modifiedPictureOrignalWidth<=modifiedPictureOrignalHeight){
					newWallpaperHeight=(int)((double)newWallpaperWidth*(double)modifiedPictureOrignalHeight/(double)modifiedPictureOrignalWidth);
					newWallpaper = ImageProcessFunction.zoomBitmap(newWallpaper, newWallpaperWidth,newWallpaperHeight);
				}else{
					newWallpaperWidth=(int)((double)newWallpaperHeight*(double)modifiedPictureOrignalWidth/(double)modifiedPictureOrignalHeight);
					newWallpaper = ImageProcessFunction.zoomBitmap(newWallpaper, newWallpaperWidth,newWallpaperHeight);
				}



				try {
					getApplicationContext().setWallpaper(newWallpaper);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Toast.makeText(ShowResult.this, "新壁纸已经设定完成!:)", Toast.LENGTH_LONG).show();


			}
		});


		//Create a button to go back to the previous view
		Button backButton =(Button) this.findViewById(R.id.back_button);
		backButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can go to the second screen to input data.
			@Override
			public void onClick(View arg0){
				Intent i = new Intent(
						ShowResult.this,
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
						ShowResult.this,
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
						ShowResult.this,
						ChoosePicture.class);

				startActivity(i);

			}
		});


	}   

	private void showResult(){   
		originalView = (ImageView)findViewById(R.id.original);  







		Drawable drawableRes = ChoosePicture.chosenPicture;
		//change drawable to bitmap
		Bitmap bitmapOriginal = ImageProcessFunction.drawableToBitmap(drawableRes);
		//Firstly, compress the picture in order to fit the screen
		bitmapOriginal = ImageProcessFunction.zoomBitmap(bitmapOriginal, 80, 80);

		//modifiedBitmap= ImageProcessFunction.zoomBitmap(modifiedBitmap, 100, 100);

		originalView.setImageBitmap(bitmapOriginal); 


		/*
		 * Proportionally compress the picture in order to fit the screen
		 */
		//get screen height and width
		int screenWidth,screenHeight;     
		WindowManager windowManager = getWindowManager();     
		Display display = windowManager.getDefaultDisplay();     
		screenWidth = display.getWidth();     
		screenHeight = display.getHeight(); 
		//get picture original height and width
		int chosenPictureOrignalWidth,chosenPictureOrignalHeight;     
		chosenPictureOrignalWidth=modifiedBitmap.getWidth();
		chosenPictureOrignalHeight=modifiedBitmap.getHeight();

		int setProperWidth,setProperHeight;
		setProperWidth=screenWidth;
		setProperHeight=(int)((double)screenWidth*(double)chosenPictureOrignalHeight/(double)chosenPictureOrignalWidth);
		modifiedBitmap = ImageProcessFunction.zoomBitmap(modifiedBitmap, setProperWidth,setProperHeight);

		modifiedView = (ImageView)findViewById(R.id.modified);


		modifiedView.setImageBitmap(modifiedBitmap); 

	}   


}  


