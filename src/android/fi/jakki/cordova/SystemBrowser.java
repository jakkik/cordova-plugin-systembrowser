/**
 */
package fi.jakki.cordova;

import android.content.Intent;
import android.net.Uri;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

public class SystemBrowser extends CordovaPlugin {
  private static final String TAG = "SystemBrowser";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing SystemBrowser");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(action.equals("open")) {
      String url = args.getString(0);
      Log.d(TAG, "Opening url " + url);

      try {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(url);
        browserIntent.setData(uri);
	this.cordova.getActivity().startActivity(browserIntent);
      } catch (java.lang.RuntimeException e) {
        Log.d(TAG, "Error opening url " + url + ": " + e.toString());
      }

    }
    return true;
  }

}
