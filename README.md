# react-native

## Android

###### Environment setup:

```
export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/emulator
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/tools/bin
export PATH=$PATH:$ANDROID_HOME/platform-tools
```

###### Use following command:
```
mkdir android/app/src/main/assets

react-native bundle --platform android --dev false --entry-file index.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res

```

###### Build your APK:
```
react-native run-android
```

## iOS

###### Build your project:
```
react-native run-ios
```

## Common

###### `App.js`

```
import {
    NativeModules,
} from 'react-native';

NativeModules.TouchPointKitBridge.setScreen(
  'Demo 2',
  true
);

openActivity = () => {
   NativeModules.TouchPointKitBridge.openActivity('Demo 1');
}


<Button
   onPress={this.openActivity}
   title="Open Activity"
   color="#FF6347" />
```


###### Process kill if 8081 port is busy

```
sudo lsof -i :8081
Kill -9 {PID}
```