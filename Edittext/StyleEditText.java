package com.kiomon.stylewall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author: MOONY
 * @data: 15/8/4
 * @Description: ${todo}<自定义edittext>
 */
public class StyleEditText extends EditText {
    public static final int MAIL_STATUS = 1;
    public static final int NAME_STATUS = 2;
    public static final int PASS_STATUS = 3;

    public StyleEditText(Context context) {
        super(context);
    }

    public StyleEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public StyleEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void checkFocusStatus(final StyleEditText styleEditText, final TextView errorText, final int editType, final StyleEditText passEditText) {

        //内容判断
        styleEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    errorText.setVisibility(View.INVISIBLE);
                } else {
                    switch (editType) {
                        //验证邮箱
                        case MAIL_STATUS:
                            if (styleEditText.getText().toString().matches("^[a-zA-Z0-9_]+@([a-zA-Z0-9]+\\.)+(com|cn|net)$") || styleEditText.getText().toString().equals("")) {
                                errorText.setVisibility(View.INVISIBLE);
                            } else {
                                //邮箱不正确
                                errorText.setVisibility(View.VISIBLE);
                                errorText.setText("邮箱输入有误");
                            }
                            break;
                        case NAME_STATUS:


                            break;
                        //验证密码相同
                        case PASS_STATUS:
                            if (styleEditText.getText().toString().equals(passEditText.getText().toString()) || styleEditText.getText().toString().equals("")) {
                                errorText.setVisibility(View.INVISIBLE);
                            } else {
                                //密码不正确
                                errorText.setVisibility(View.VISIBLE);
                                errorText.setText("密码输入不一致");
                            }
                            break;
                    }
                }
            }
        });
    }
}
