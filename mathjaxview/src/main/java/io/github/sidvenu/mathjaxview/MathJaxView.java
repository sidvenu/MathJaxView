package io.github.sidvenu.mathjaxview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MathJaxView extends WebView {

    String text, config;

    public MathJaxView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        setBackgroundColor(Color.TRANSPARENT);

        // default config for MathJax
        config = "MathJax.Hub.Config({\n" +
                "    messageStyle: 'none',\n" +
                "    \"fast-preview\": {\n" +
                "      Chunks: {EqnChunk: 10000, EqnChunkFactor: 1, EqnChunkDelay: 0},\n" +
                "      color: \"inherit!important\",\n" +
                "      updateTime: 30, updateDelay: 6,\n" +
                "      disabled: false\n" +
                "    },\n" +
                "    tex2jax: {\n" +
                "      inlineMath: [ ['$','$'] ],\n" +
                "      displayMath: [ ['$$','$$'] ],\n" +
                "      processEscapes: true\n" +
                "    },\n" +
                "    TeX: {\n" +
                "      extensions: [\"file:///android_asset/MathJax/extensions/TeX/mhchem.js\"]\n" +
                "    }\n" +
                "});";

        // render MathJax once page finishes loading
        setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:MathJax.Hub.Queue(['Typeset',MathJax.Hub]);");
            }
        });
    }

    /**
     * I have included a default config that will be convenient for most of the people.
     * If you need to edit that config , please use this method to set your own MathJax config,
     * and note to call this before calling setText(String)
     * @param config MathJax configuration to be used
     */
    public void setConfig(String config) {
        this.config = config;
    }

    /**
     * Renders MathJax code that is found in the passed-in string
     * @param text Text that contains the MathJax to be rendered
     */
    public void setText(String text) {
        this.text = text;
        loadDataWithBaseURL("about:blank",
                "<html><head>" +
                        " <meta name=\"viewport\" content=\"width=device-width, user-scalable=yes\" />" +
                        "</head>" +
                        "" +
                        "<body>" +
                        text +
                        "</br> " +
                        "<script type=\"text/x-mathjax-config\">" +
                        config +
                        "</script>" +
                        "<script type=\"text/javascript\" async src=\"file:///android_asset/MathJax/MathJax.js?config=TeX-AMS-MML_HTMLorMML\"></script>" +
                        "" +
                        "</body>" +
                        "</html>", "text/html", "utf-8", "");
    }

    /**
     * Returns the MathJax code that was passed into using setText
     * @return raw MathJax code
     */
    @Nullable
    public String getText(){
        return text;
    }
}
