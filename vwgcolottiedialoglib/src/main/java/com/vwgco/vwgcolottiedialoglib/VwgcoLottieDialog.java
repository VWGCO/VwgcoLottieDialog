/*
 * Copyright (c) 2021. Create by VWGCO
 */

package com.vwgco.vwgcolottiedialoglib;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;



public class VwgcoLottieDialog {

    private String title, message, positiveBtnText, negativeBtnText;
    @ColorRes
    private int pBtnColor, nBtnColor;
    private Context context;
    private VwgcoLottieDialogListener pListener, nListener;
    private Dialog.OnCancelListener cancelListener;
    private boolean cancel;
    int lottieImageResource;


    private VwgcoLottieDialog(Builder builder) {
        this.title = builder.title;
        this.message = builder.message;
        this.context = builder.context;
        this.pListener = builder.pListener;
        this.nListener = builder.nListener;
        this.pBtnColor = builder.pBtnColor;
        this.nBtnColor = builder.nBtnColor;
        this.positiveBtnText = builder.positiveBtnText;
        this.negativeBtnText = builder.negativeBtnText;
        this.lottieImageResource = builder.lottieImageResource;
        this.cancel = builder.cancel;
        this.cancelListener = builder.cancelListener;
    }


    public static class Builder {
        private String title, message, positiveBtnText, negativeBtnText;
        @ColorRes
        private int pBtnColor, nBtnColor;
        private Context context;
        private VwgcoLottieDialogListener pListener, nListener;
        private boolean cancel;
        int lottieImageResource;
        private Dialog.OnCancelListener cancelListener;


        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(@StringRes int title) {
            return setTitle(context.getString(title));
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(@StringRes int message) {
            return setMessage(context.getString(message));
        }

        public Builder setPositiveBtnText(String positiveBtnText) {
            this.positiveBtnText = positiveBtnText;
            return this;
        }

        public Builder setPositiveBtnText(@StringRes int positiveBtnText) {
            return setPositiveBtnText(context.getString(positiveBtnText));
        }

        public Builder setPositiveBtnBackground(@ColorRes int pBtnColor) {
            this.pBtnColor = pBtnColor;
            return this;
        }

        public Builder setNegativeBtnText(String negativeBtnText) {
            this.negativeBtnText = negativeBtnText;
            return this;
        }

        public Builder setNegativeBtnText(@StringRes int negativeBtnText) {
            return setNegativeBtnText(context.getString(negativeBtnText));
        }

        public Builder setNegativeBtnBackground(@ColorRes int nBtnColor) {
            this.nBtnColor = nBtnColor;
            return this;
        }

        //set Positive listener
        public Builder OnPositiveClicked(VwgcoLottieDialogListener pListener) {
            this.pListener = pListener;
            return this;
        }

        //set Negative listener
        public Builder OnNegativeClicked(VwgcoLottieDialogListener nListener) {
            this.nListener = nListener;
            return this;
        }

        public Builder isCancellable(boolean cancel) {
            this.cancel = cancel;
            return this;
        }

        public Builder setOnCancelListener(Dialog.OnCancelListener cancelListener) {
            this.cancelListener = cancelListener;
            return this;
        }

        public Builder setlottieResource(int lottieImageResource) {
            this.lottieImageResource = lottieImageResource;
            return this;
        }

        public VwgcoLottieDialog build() {
            TextView message1, title1;
            Button nBtn, pBtn;
            LottieAnimationView lottieImageView;

            final Dialog dialog;
            dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            if (dialog.getWindow() != null)
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(cancel);
            dialog.setContentView(R.layout.vwgcolottiedialog);


            //getting resources
            title1 = (TextView) dialog.findViewById(R.id.title);
            message1 = (TextView) dialog.findViewById(R.id.message);
            nBtn = (Button) dialog.findViewById(R.id.negativeBtn);
            pBtn = (Button) dialog.findViewById(R.id.positiveBtn);

            lottieImageView = dialog.findViewById(R.id.lottieImageView);
            lottieImageView.setAnimation(lottieImageResource);


            title1.setText(title);
            message1.setText(message);
            if (positiveBtnText != null)
                pBtn.setText(positiveBtnText);
            if (negativeBtnText != null)
                nBtn.setText(negativeBtnText);
            GradientDrawable pbgShape = (GradientDrawable) pBtn.getBackground();
            pbgShape.setColor(ContextCompat.getColor(context, pBtnColor));
            GradientDrawable nbgShape = (GradientDrawable) nBtn.getBackground();
            nbgShape.setColor(ContextCompat.getColor(context, nBtnColor));
            if (pListener != null) {
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pListener.OnClick();
                        dialog.dismiss();
                    }
                });
            } else {
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }

                });
            }

            if (nListener != null) {
                nBtn.setVisibility(View.VISIBLE);
                nBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nListener.OnClick();
                        dialog.dismiss();
                    }
                });
            }

            if (cancelListener != null)
                dialog.setOnCancelListener(cancelListener);


            dialog.show();

            return new VwgcoLottieDialog(this);
        }
    }

}
