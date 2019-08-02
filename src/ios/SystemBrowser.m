#import "SystemBrowser.h"

#import <Cordova/CDVAvailability.h>

@implementation SystemBrowser

- (void)pluginInitialize {
}

- (void)open:(CDVInvokedUrlCommand *)command {
  NSURL* url = [NSURL URLWithString:[command.arguments objectAtIndex:0]];
  NSLog(@"SystemBrowser: Opening url %@", url);

  [[UIApplication sharedApplication] openURL:url];
}

@end
