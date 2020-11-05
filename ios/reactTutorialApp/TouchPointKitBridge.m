//
//  TouchPointKitBridge.m
//  reactTutorialApp
//
//  Created by Dinesh Tanwar on 03/11/20.
//

#import "TouchPointKitBridge.h"
@import TouchPointKit;

@implementation TouchPointKitBridge

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(setScreen:(NSString *)name banner:(BOOL)banner)
{
  [[TouchPointActivity shared] setScreenNameWithScreenName:name banner:banner];
}

RCT_EXPORT_METHOD(openActivity:(NSString *)name)
{
  if ([[TouchPointActivity shared] shouldShowActivityWithScreenName: name]) {
    dispatch_sync(dispatch_get_main_queue(),^(void){
        [[TouchPointActivity shared] openActivityWithScreenName: name delegate: nil];
    });
  }
}

@end
