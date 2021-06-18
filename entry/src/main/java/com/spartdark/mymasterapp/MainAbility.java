package com.spartdark.mymasterapp;

import com.spartdark.mymasterapp.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.bundle.IBundleManager;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class MainAbility extends Ability {
    static final HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 1, MainAbility.class.getSimpleName());
    private static final int MY_PERMISSIONS_REQUEST_CAMERA= 001;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
        HiLog.info(label,"onStart() ");
        //verifico los  permisos
        //requestPermissionsFromUser(new String[]{"ohos.permission.DISTRIBUTED_DATASYNC"}, 0);

        if (verifySelfPermission("ohos.permission.DISTRIBUTED_DATASYNC") != IBundleManager.PERMISSION_GRANTED) {
            HiLog.info(label,"Permission denied");
            // The application has not been granted the permission.
            if (canRequestPermission("ohos.permission.DISTRIBUTED_DATASYNC")) {
                // Check whether permission authorization can be implemented via a dialog box (at initial request or when the user has not chosen the option of "don't ask again" after rejecting a previous request).
                requestPermissionsFromUser(
                        new String[] { "ohos.permission.DISTRIBUTED_DATASYNC" } , MY_PERMISSIONS_REQUEST_CAMERA);
            } else {
                // Display the reason why the application requests the permission and prompt the user to grant the permission.
                HiLog.info(label,"permission denied");
            }
        } else {
            // The permission has been granted.
            HiLog.info(label,"permission granted");
        }

        //int type = intent.getIntParam("type",2);
        //HiLog.info(label,"Data: "+type);
    }

    @Override
    public void onRequestPermissionsFromUserResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsFromUserResult(requestCode, permissions, grantResults);
    }
}
