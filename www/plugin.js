
var exec = require('cordova/exec');

var PLUGIN_NAME = 'SystemBrowser';

var SystemBrowser = {
  open: function(url, cb) {
    exec(cb, null, PLUGIN_NAME, 'open', [url]);
  }
};

module.exports = SystemBrowser;
