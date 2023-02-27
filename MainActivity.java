package com.gotoubun;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.print.PrintAttributes;
import android.provider.MediaStore;
import android.text.Html;
import android.text.InputFilter;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Process;
import android.provider.Settings;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.gotoubun.Auth;

import android.content.ClipboardManager;
import android.content.ClipData;
import android.content.ClipData.Item;


import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.RelativeLayout.ALIGN_PARENT_BOTTOM;
import static android.widget.RelativeLayout.ALIGN_PARENT_LEFT;
import static android.widget.RelativeLayout.ALIGN_PARENT_RIGHT;
import static android.widget.RelativeLayout.CENTER_HORIZONTAL;
import static android.widget.RelativeLayout.CENTER_IN_PARENT;
import static android.widget.RelativeLayout.CENTER_VERTICAL;
import static java.lang.System.loadLibrary;
import com.gotoubun.Floating;
import android.os.health.TimerStat;
import android.text.format.Time;

public class MainActivity extends Activity {
    public String sGameActivity = "com.tencent.tmgp.cod.CODMainActivity";
    private native String YTURL();
    private native String Dialog();

    
    String base64String2 = "data:image/png;base64,";
    String base64Image2 = base64String2.split(",")[1];
    String base64String3 = "data:image/png;base64,";
    String base64Image3 = base64String3.split(",")[1];


    CheckBox showChkBox;
    EditText mail, pass;
    Button init,initt;
    private GradientDrawable gdAnimation = new GradientDrawable();
    private final GradientDrawable gdAnimation2 = new GradientDrawable();
	private final GradientDrawable gdAnimation3 = new GradientDrawable();
	

    private void SetupForm() {
        float[] outerRadii = new float[]{3,3,3,3,3,3,3,3};
        float[] innerRadii = new float[]{3,3,3,3,3,3,3,3};
        requestWindowFeature(1);
        getWindow().setFlags(1024, 2000);
        ShapeDrawable shape = new ShapeDrawable(new RoundRectShape(outerRadii, null, innerRadii));
        shape.getPaint().setColor(Color.parseColor("#FFFFFF"));
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(5);
        shape.setPadding(3,3,3,3);

        //gd1
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(Color.YELLOW);
       gd.setCornerRadius(10);
       gd.setAlpha(50);
        //gd2
        
        LinearLayout layoutPrincipal = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);

        layoutPrincipal.setLayoutParams(layoutParams);
        layoutPrincipal.setGravity(25);
        layoutPrincipal.setOrientation(LinearLayout.VERTICAL);
        layoutPrincipal.setBackgroundColor(Color.TRANSPARENT);

        //Add relative layout
        RelativeLayout relativeLayout = new RelativeLayout(this);
        //RelativeLayout.setGravity(25);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackground(gdAnimation);
     //   linearLayout.setPadding(convertDipToPixels(15.0f), convertDipToPixels(15.0f), convertDipToPixels(15.0f), convertDipToPixels(15.0f));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //add view form
        LinearLayout linearLayout2 = new LinearLayout(this);
        // use esse pois 茅 mais compativel,entretanto as imagens tem de ser maior
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(convertDipToPixels(500.0f), -39);
        //RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(1000, 650);

        linearLayout2.setBackgroundColor(Color.rgb(45, 255, 0));
        //linearLayout2.setAlpha(07);
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
        rlp.addRule(CENTER_IN_PARENT);
        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        linearLayout2.setLayoutParams(rlp);
        linearLayout2.setBackground(gdAnimation3);

       
        //define img edit user
        ImageView imageView2 = new ImageView(this);
        byte[] decodedString2 = Base64.decode(base64Image2, Base64.DEFAULT);
        Bitmap decodedByte2 = BitmapFactory.decodeByteArray(decodedString2, 0, decodedString2.length);
        imageView2.setImageBitmap(decodedByte2);

        //define img edit pass
        ImageView imageView3 = new ImageView(this);
        byte[] decodedString3 = Base64.decode(base64Image3, Base64.DEFAULT);
        Bitmap decodedByte3 = BitmapFactory.decodeByteArray(decodedString3, 0, decodedString3.length);
        imageView3.setImageBitmap(decodedByte3);

        //login

        //create drawable
        // Drawable d = new BitmapDrawable(decodedByte2);
        Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(decodedByte2, 50, 50, true));
        Drawable d2 = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(decodedByte3, 50, 50, true));
        //     Drawable d3 = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(decodedByte4, 50, 50, true));
        LinearLayout linearLayoutc = new LinearLayout(this);
        linearLayoutc.setBackgroundColor(Color.TRANSPARENT);
        linearLayoutc.setOrientation(LinearLayout.HORIZONTAL);


        RadioButton rd = new RadioButton(this);
        //pregui莽a de por margin
        rd.setText("Show Key");
        if (Build.VERSION.SDK_INT > 23) {
            rd.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));//setButtonTintList is accessible directly on API>19
        }

        rd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


        RadioButton rd2 = new RadioButton(this);
        rd2.setText("Remember");
         rd2.setTextColor(Color.parseColor("#FFFFFF"));
        RelativeLayout.LayoutParams rlp333 = new RelativeLayout.LayoutParams(-1, convertDipToPixels(40.0f));
        rlp333.setMargins(60,10,60,11);
        rd2.setLayoutParams(rlp333);
        
        
        if (Build.VERSION.SDK_INT > 23) {
            rd2.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));//setButtonTintList is accessible directly on API>19
        }

        rd2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    prefs.write(USER, mail.getText().toString());
                   
                } else {
                   // pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

		
        final TextView maill = new TextView(this);
		GradientDrawable gradientDrawable1 =new GradientDrawable();
	//	gradientDrawable1.setStroke((3),Color.parseColor("#ff0505"));
	//	gradientDrawable1.setColor(Color.GREEN);
	//	gradientDrawable1.setCornerRadius(40);
    // change here
		maill.setBackground(gradientDrawable1);
        maill.setText("𝔹𝕌𝕐 𝕂𝔼𝕐 @yesimhanz");
        maill.setTextSize(30.0f);

        LinearLayout.LayoutParams name22 = new LinearLayout.LayoutParams(-10,-10);
        name22.gravity = 17;
        name22.setMargins(0,convertDipToPixels(0.0f),0,0);
        maill.setLayoutParams(name22);

     
        //Username form
        pass = new EditText(this);
        pass.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        pass.setHint("ᴋᴇʏ :");
        pass.setHintTextColor(Color.parseColor("#FFFFFF"));
        pass.setTextColor(Color.parseColor("#FFFFFF"));
        pass.setSingleLine(true);
        pass.setBackground(shape);
        pass.setCompoundDrawablesWithIntrinsicBounds(d2, null, null, null);
        pass.setCompoundDrawablePadding(11);
        // mail.setBackground(gd2);
        pass.setPadding(convertDipToPixels(15.0f), convertDipToPixels(15.0f), convertDipToPixels(15.0f), convertDipToPixels(15.0f));
        pass.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});

          //Username form
        mail = new EditText(this);
        RelativeLayout.LayoutParams rlp33 = new RelativeLayout.LayoutParams(-1, convertDipToPixels(40.0f));
        mail.setHint("ᴘʟᴇᴀsᴇ ᴇɴᴛᴇʀ ʏᴏᴜʀ ᴋᴇʏ...");
         rlp33.setMargins(60,10,60,11);
        mail.setHintTextColor(Color.parseColor("#FFFFFF"));
        mail.setTextColor(Color.parseColor("#FFFFFF"));
        mail.setSingleLine(true);
        mail.setLayoutParams(rlp33);
        mail.setBackground(shape);
        mail.setCompoundDrawablesWithIntrinsicBounds(d2, null, null, null);
        pass.setCompoundDrawablePadding(8);
        // mail.setBackground(gd2);
        mail.setPadding(convertDipToPixels(10.0f), convertDipToPixels(10.0f), convertDipToPixels(10.0f), convertDipToPixels(10.0f));
        mail.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
        //button
        init = new Button(this);
        RelativeLayout.LayoutParams rlp3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, convertDipToPixels(40.0f));
        init.setText("SIGN IN");
        init.setWidth(200); // set the width to 200 pixels
        rlp3.setMargins(250,10,250,30);
        init.setTextSize(15.0f);
        init.setBackground(gdAnimation2);
        init.setGravity(Gravity.CENTER);
        init.setLayoutParams(rlp3);
        init.setTextColor(Color.parseColor("#FFFFFF"));
        
        int colorFrom = Color.parseColor("#FFFFFF");
        int colorTo = Color.parseColor("#FFFFFF");
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(5000); // milliseconds
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                init.setTextColor((int) animator.getAnimatedValue());
                maill.setTextColor((int) animator.getAnimatedValue());
                mail.setTextColor((int) animator.getAnimatedValue());
                
            }

        });  

        paste = new Button(this);
        RelativeLayout.LayoutParams rlp4 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, convertDipToPixels(40.0f));
        paste.setText("PASTE");
        rlp4.setMargins(50, 10, 50, 30);
        paste.setTextSize(15.0f);
        paste.setBackground(gdAnimation2);
        paste.setGravity(Gravity.CENTER);
        paste.setLayoutParams(rlp4);
        paste.setTextColor(Color.parseColor("#FFFFFF"));
        paste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                if (clipboard.hasPrimaryClip()) {
                    ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
                    String pasteData = item.getText().toString();
                    mail.setText(pasteData);
                }
            }
        });

          colorAnimation.start();

        
        //Footer text
        LinearLayout linearLayout3 = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(12);
        linearLayout3.setLayoutParams(layoutParams5);
        linearLayout3.setOrientation(LinearLayout.VERTICAL);
        
        //Add views
        //    linearLayout2.addView(imageView);
        linearLayout2.addView(maill);
       linearLayout2.addView(mail);
        linearLayout2.addView(linearLayoutc);
       //linearLayoutc.addView(rd);
        linearLayoutc.addView(rd2);
        linearLayout2.addView(init);
     //  linearLayout2.addView(initt);
        relativeLayout.addView(linearLayout);
       // relativeLayout.addView(Creditos);
        relativeLayout.addView(linearLayout2);

       // relativeLayout.addView(linearLayout);
        

        setContentView(relativeLayout);
        TryLoginPHP();
    }



    private final String USER = "USER";
    private Prefs prefs;
    private void TryLoginPHP() {
        prefs = Prefs.with(this);

        mail.setText(prefs.read(USER, ""));
     


        init.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), Auth.class);
                

                if (!mail.getText().toString().isEmpty()) {
                  
                    new Auth(MainActivity.this).execute(mail.getText().toString());
                }
                
                if (mail.getText().toString().isEmpty()) {
                    mail.setError("𝕂𝔼𝕐 ℝ𝔼ℚ𝕌𝕀ℝ𝔼𝔻!");
                }
                
            }
        });



    }
    private int convertDipToPixels(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }



    public String urlRequest(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openConnection().getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void startAnimation() {
        final int start = Color.parseColor("#292A27");
        final int end = Color.parseColor("#292A27");

        final ArgbEvaluator evaluator = new ArgbEvaluator();
        gdAnimation.setCornerRadius(0);
        gdAnimation.setOrientation(GradientDrawable.Orientation.TL_BR);
        final GradientDrawable gradient = gdAnimation;

        ValueAnimator animator = TimeAnimator.ofFloat(0.0f, 1.0f);
        animator.setDuration(10000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float fraction = valueAnimator.getAnimatedFraction();
                int newStrat = (int) evaluator.evaluate(fraction, start, end);
                int newEnd = (int) evaluator.evaluate(fraction, end, start);
                int[] newArray = {newStrat, newEnd};
                gradient.setColors(newArray);
            }
        });

        animator.start();
    }
    public void startAnimation2() {
        final int start = Color.parseColor("#000000");
        final int end = Color.parseColor("#000000");

        final ArgbEvaluator evaluator = new ArgbEvaluator();
        gdAnimation.setCornerRadius(50);
        gdAnimation.setOrientation(GradientDrawable.Orientation.TL_BR);
        final GradientDrawable gradient = gdAnimation2;

        ValueAnimator animator2 = TimeAnimator.ofFloat(0.0f, 1.0f);
        animator2.setDuration(10000);
        animator2.setRepeatCount(ValueAnimator.INFINITE);
        animator2.setRepeatMode(ValueAnimator.REVERSE);
        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator valueAnimator) {
					Float fraction = valueAnimator.getAnimatedFraction();
					int newStrat = (int) evaluator.evaluate(fraction, start, end);
					int newEnd = (int) evaluator.evaluate(fraction, end, start);
					int[] newArray = {newStrat, newEnd};
					gradient.setColors(newArray);
				}
			});

        animator2.start();
    }
	public void startAnimation3() {
        final int start2 = Color.parseColor("#000000");
        final int end2 = Color.parseColor("#000000");
		
        final ArgbEvaluator evaluator2 = new ArgbEvaluator();
        gdAnimation3.setCornerRadius(20);
        gdAnimation3.setOrientation(GradientDrawable.Orientation.TL_BR);
        final GradientDrawable gradient3 = gdAnimation3;

        ValueAnimator animator3 = TimeAnimator.ofFloat(0.0f, 1.0f);
        animator3.setDuration(10000);
        animator3.setRepeatCount(ValueAnimator.INFINITE);
        animator3.setRepeatMode(ValueAnimator.REVERSE);
        animator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator valueAnimator2) {
					Float fraction2 = valueAnimator2.getAnimatedFraction();
					int newStrat2 = (int) evaluator2.evaluate(fraction2, start2, end2);
					int newEnd2 = (int) evaluator2.evaluate(fraction2, end2, start2);
					int[] newArray2 = {newStrat2, newEnd2};
					gradient3.setColors(newArray2);
				}
			});

        animator3.start();
    }
	
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Launcher.Init(this);

		
        loadLibrary("ZGMODZ");
		startAnimation2();
        SetupForm();
        startAnimation();
		startAnimation3();

        Intent intent = new Intent(this, Floating.class);
        startService(intent);

    }
}


//CREDIT TO THE OWNER
        
