package com.picturefactory;

import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * ChoosePicture类定义了用户开始进行图片处理时,进行待处理的图片选择的画面.
 * 画面中包含三个按钮,分别可以选择:处理手机当前的壁纸;从相册中选择图片进行处理;打开手机浏览器连接百度搜索引擎搜索图片
 * 本类通过WelcomeScreen类中的“开始”按钮点击调用
 * 对应的布局文件名:choose_picture_layout.xml
 * 
 * Code for choosing picture from a gallery browser is referred to http://www.zxhwolfe.com/archives/165
 * The rest part of the part is originally created by Zhou Xingyue, if no statement declared.
 * 
 * 
 * Date: 2010/12/5
 * @author Zhou Xingyue
 *
 */
public class ChoosePicture extends Activity {
	public static Drawable chosenPicture;
	public static int chosenPictureWidth;
	public static int chosenPictureHeight;
	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);
		setContentView(R.layout.choose_picture_layout);//set the first view to welcome the user

		//Click this button to process wallpaper
		Button wallpaperButton =(Button) this.findViewById(R.id.wallpaper_button);
		wallpaperButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can choose to process the wallpaper
			@Override
			public void onClick(View arg0){
				chosenPicture = getWallpaper(); 
				//chosenPicture=getResources().getDrawable(R.drawable.sample);
				Drawable drawableTemp = ChoosePicture.chosenPicture;
				//change Drawable to Bitmap   
				Bitmap chosenPictureTemp = ImageProcessFunction.drawableToBitmap(drawableTemp);



				chosenPictureWidth= chosenPictureTemp.getHeight();
				chosenPictureHeight=chosenPictureTemp.getWidth();



				Log.d("ZhouXingyue","wallpaper was chosen");

				Intent i = new Intent(
						ChoosePicture.this,
						BasicFunctionList.class);

				startActivity(i);
				Log.d("ZhouXingyue","processing levels should be shown");

			}
		});


		Button otherButton =(Button) this.findViewById(R.id.other_button);
		otherButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can choose to process the picture from gallery
			@Override
			public void onClick(View arg0){


				Log.d("ZhouXingyue","other picture was chosen");


				/**
				 * code for opening up a gallery browser
				 */


				// To open up a gallery browser
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(Intent.createChooser(intent, "Select Picture"),1);


			}
		});


		/**
		 * Create a start button to go to a web site
		 */
		Button webButton =(Button) this.findViewById(R.id.web_button);
		webButton.setOnClickListener(new OnClickListener(){
			//By pressing the button on this screen, user can open a website
			@Override
			public void onClick(View arg0){
				Intent openWebsite = new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("http://www.image.baidu.com")

				);
				startActivity(openWebsite);


				Log.d("ZhouXingyue","website opened");

			}
		});
		/**
		 * End of create a button to go to a web site
		 */



	}


	/**
	 * code for choosing picture from a gallery browser
	 * Referred to http://www.zxhwolfe.com/archives/165
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			Uri uri = data.getData();
			ContentResolver cr = this.getContentResolver();
			try{
				Bitmap galleryBitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
				BitmapDrawable galleryDrawable= new BitmapDrawable(galleryBitmap);
				chosenPicture=galleryDrawable;



				chosenPictureWidth= galleryBitmap.getHeight();
				chosenPictureHeight=galleryBitmap.getWidth();
				Log.d("ZhouXingyue","picture from gallery was chosen");

				Intent i = new Intent(
						ChoosePicture.this,
						BasicFunctionList.class);

				startActivity(i);
				Log.d("ZhouXingyue","processing levels should be shown");
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}

	}
	/**
	 * end code for choosing picture from a gallery browser
	 */

}
