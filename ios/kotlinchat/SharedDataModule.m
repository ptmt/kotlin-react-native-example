#import "SharedDataModule.h"
#import "SharedData/SharedData.h"

@implementation RCTSharedDataModule

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(generateMessages:(NSNumber *__nonnull)length
                  resolve:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  NSArray* messages = [SharedData generateMessagesNumber:length.intValue];
  resolve(messages);
}
@end
