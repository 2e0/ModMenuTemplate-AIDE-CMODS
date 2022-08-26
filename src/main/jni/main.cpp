#include <pthread.h>
#include <jni.h>
#include <Includes/Utils.h>
#include <Substrate/SubstrateHook.h>
#include "KittyMemory/MemoryPatch.h"
#include "Chams.h"

extern "C" {

/*Time For Bools And all*/

bool ping = false;
bool fireRate = false;
bool chams = false;
bool wireframe = false;
bool outline = false;
bool ammo = true;
bool glow = false;
bool shading = false;
bool rainbow = false;
bool radar = false;
bool flash = false;
bool money = false;
bool SetWin = false;
int WinTeam = 1;
bool nospread = false;
bool buy = false;
float f2;
float f1;
bool speedhack = false;
bool defuse = false;
int speed;
int noValue = 0;
int fovValue = 0;
bool fovFeature = false;
int healthValue = 100;
bool healthFeature = false;
bool plantAny = false;
int weaponid = 0;
int setval = 1;
int setvalgl;
bool setgl = false;
bool setbutt = false;
bool skin = false;
int skinid = 0;
bool recoil = false;
bool spread = false;
bool aimebat = false;
bool aimebat2 = false;
bool aimebat3 = false;
bool LongFeature = false;
int LongValue = 2;
bool dont = false;
bool plant = false;
bool resp = false;
bool movebef = false;
bool noclip = false;

const char *libName = "libil2cpp.so";
struct My_Patches {MemoryPatch Kik1, Kik2, Kik3, Kik4, Kik5, Kik6, Kik7, Kik8, Kik9, Kik10, FireRate, Recoil, Spread, AimOff, AimLegit, AimMedium, AimHigh, Plant, Defuse, Buy, Respawn, Move, Dont, InfAmmo, Noclip, Bypass1, Bypass2, Bypass3, Bypass4, Bypass5, Bypass6, Bypass7, Bypass8, Bypass9, Bypass10, Bypass11, Bypass12, Bypass13, Bypass14, Bypass15, Bypass16, Bypass17, Bypass18, Bypass19, Bypass20, Bypass21, Bypass22, Bypass23, Bypass24, Bypass25, Bypass26, Bypass27, Bypass28, Bypass29, Bypass30, Bypass31, Bypass32, Bypass33, Bypass34, Bypass35, Bypass36, Bypass37, Bypass38, Bypass39, Bypass40, Bypass41, Bypass42;} hexPatches;

JNIEXPORT jobjectArray  JNICALL Java_il2cpp_Main_getFeatures(JNIEnv *env, jobject activityObject) {
	jobjectArray ret;
	// switch_featureid_text
	// page_text_icon
	const char *features[] = {
  "page_Player_player.png",
  "page_Aim_Aim.png",
  "page_Skins_Skins.png",
    "page_Chams_Visual.png",
 
  "BLOCK_0_Legit,Rage", // 0, 1
    "BLOCK_1_Aimbot", // 2, 3
  "BLOCK_2_Weapon,Gloves", // 4, 5
  //************
  //****Player Weapon Skins****
  "BLOCK_3_Chams,Settings", // 6, 7
  //************
  
  // player - weapon - Game (0)******!!!
  //"title_0_Player",
   "switch_1_0_Radar Hack_1",
  "switch_2_0_Money Hack_2",
  "switch_3_0_No Recoil + No Spread_3",
  "switch_5_0_Anti Flash_5",
  "switch_6_0_Ping Hack_6",
  "switch_98_1_Dont Return Spawn_98",
  "switch_99_1_Respawn Hack_99",
  "switch_101_1_Move Before Timer(Buggy)_101",
  "switch_103_1_Noclip_103",
  "switch_87_0_Buy Anywhere_87",
  "switch_95_0_Plant Anywhere_95",
  "switch_96_0_Defuse Anywhere_96",
  "switch_106_1_FireRate_106",
  "switch_110_1_Unlimited Ammo_110",
  "switch_62_0_Fov Hook_62",
    "slider_65_0_Fov_200_0_65",
  "switch_7_0_Fly_7",
  "slider_8_0_Spd Fly_150_0_8",
  "switch_50_1_Fly ground_50",
  "slider_51_1_Speed (FG)_150_0_51",
   "switch_67_1_Set HP_67",
  "slider_69_1_Set HP_999_0_69",
  "switch_9_2_Aim - Legit_9",
  "switch_10_2_Aim - Medium_10",
  "switch_11_2_Aim - High_11",
    "slider_20_3_ID_51_0_20",
  "slider_21_4_ID_37_0_21",
  "switch_12_5_Wireframe_12",
  "switch_13_5_Glow_13",
  "switch_15_5_Shading_14",
  "switch_15_5_Rainbow_15",
  "slider_16_6_Red_255_0_16",
  "slider_17_6_Green_255_0_17",
  "slider_18_6_Blue_255_0_18",
		
	};
	int Total_Feature = (sizeof features /
						 sizeof features[0]); //Now you dont have to manually update the number everytime;
	
	ret = (jobjectArray) env->NewObjectArray(Total_Feature, env->FindClass("java/lang/String"), env->NewStringUTF(""));
	int i;
	for (i = 0; i < Total_Feature; i++)
		env->SetObjectArrayElement(ret, i, env->NewStringUTF(features[i]));
	return (ret);
}

void hexChange(bool &var, MemoryPatch &patch) {
	var = !var;
	if (var) {
		patch.Modify();
	} else {
		patch.Restore();
	}
}

JNIEXPORT void JNICALL
Java_il2cpp_Main_Changes(JNIEnv *env,jobject activityObject,jint feature,jint value) {
	/*  FEATURES  */
	switch (feature) {
		case 12:
	wireframe = !wireframe;
    if (wireframe) {
    SetWallhackW(true);  
    } else {
    SetWallhackW(false);  
    }
	break;
	
	case 13:
	glow = !glow;
    if (glow) {
    SetWallhackG(true);
    } else {
    SetWallhackG(false);
    }
	break;
	
	case 14:
	shading = !shading;
    if (shading) {
    SetWallhackS(true);
    } else {
    SetWallhackS(false);
    }
    break;
	
	case 15:
	rainbow = !rainbow;
    if (rainbow) {
    SetRainbow(true);
    } else {
    SetRainbow(false);
    }
    break;
	
	case 16:
	SetR(value);
	break;
	
	case 17:
	SetG(value);
	break;
	
	case 18:
	SetB(value);
	break;
	
	case 1:
	radar = !radar;
	break;
	
	case 2:
	money = !money;
	break;
	
	case 3:
	recoil = !recoil;
	if (recoil) {
	hexPatches.Recoil.Modify();
	hexPatches.Spread.Modify();
	} else {
	hexPatches.Recoil.Restore();
	hexPatches.Spread.Restore();
	}
	break;
	
	case 5:
	flash = !flash;
	break;
	
	case 6:
	ping = !ping;
	break;
	
	case 7:
	f1 = !f1;
	break;
	
	case 8:
	f2 = value;
	break;
	
	case 9:
	aimebat = !aimebat;
	if (aimebat) {
	hexPatches.AimLegit.Modify();
	} else {
	hexPatches.AimLegit.Restore();
	}
	break;
	
	case 10:
	aimebat2 = !aimebat2;
	if (aimebat2) {
	hexPatches.AimMedium.Modify();
	} else {
	hexPatches.AimMedium.Restore();
	}
	break;
	
	case 11:
	aimebat3 = !aimebat3;
	if (aimebat3) {
	hexPatches.AimHigh.Modify();
	} else {
	hexPatches.AimHigh.Restore();
	}
	break;
	
	case 20:
	setbutt = !setbutt;
	setval = value;
	break;
	
	case 21:
	setgl = !setgl;
	setvalgl = value;
	break;
	
	case 50:
    LongFeature = !LongFeature;
	break;
	
	case 51:
	LongValue = value;
	break;
	
	case 62:
	fovFeature = !fovFeature;
    break;
    
    case 65:
    fovValue = value;
    break;
    
    case 67:
    healthFeature = !healthFeature;
    break;
    
    case 69:
    healthValue = value;
    break;
    
	case 96:
    hexChange(defuse, hexPatches.Defuse);
    break;
    
	case 95:
    hexChange(plant, hexPatches.Plant);
    break;
	
	case 87:
    hexChange(buy, hexPatches.Buy);
    break;
	
	case 98:
    hexChange(dont, hexPatches.Dont);
    break;

	case 99:
    hexChange(resp, hexPatches.Respawn);
    break;

    case 101:
    hexChange(movebef, hexPatches.Move);
    break;
    
	case 103:
    hexChange(noclip, hexPatches.Noclip);
    break;
	
	case 106:
    hexChange(fireRate, hexPatches.FireRate);
    break;
	
	case 110:
    ammo = !ammo;
    break;
		
	}
}

// EXTERN END
}

// ---------- Hooking ---------- //

void (*old_LongHack)(void *instance, float pisa, bool pis);//done Fly Grounded  work 
void LongHack(void *instance, float pisa, bool pis) {
    if (instance != NULL) {
        if (LongFeature) {
         pisa = LongValue;
         pis = true;
        }
    }
    old_LongHack(instance, pisa, pis);
}

void(*old_GameMode_Update)(void *MadeByWanesi);
void GameMode_Update(void *MadeByWanesi)
{
    if(MadeByWanesi != NULL) {
        if (f1) {
            *(bool *) ((uint64_t) MadeByWanesi + 0x1C) = true;
			*(float *) ((uint64_t) MadeByWanesi + 0x14) = f2;
		} else {
		    *(bool *) ((uint64_t) MadeByWanesi + 0x1C) = false;
        }
        if (speedhack) {
		    *(float *) ((uint64_t) MadeByWanesi + 0x14) = speed;
		}
    }
    old_GameMode_Update(MadeByWanesi);
}

void (*WEAPON)(void* _this, int);
void(*old_GAMEUPDATE)(void *instance);
void GAMEUPDATE(void *instance) {
    if (instance != NULL) {
        if (setbutt) {
            WEAPON(instance, setval);
			}
    }
    old_GAMEUPDATE(instance);
}

void (*GLOVES)(void* _this, int);
void(*old_GAMEUPDATE1)(void *instance);
void GAMEUPDATE1(void *instance) {
    if (instance != NULL) {
        if (setgl) {
            GLOVES(instance, setvalgl);
   }
    }
    old_GAMEUPDATE1(instance);
}

bool (*old_Ping)(void *instance);
bool Ping(void *instance) {
    if (ping) {
        return true;
    }
    return old_Ping(instance);
}

bool (*old_Radar)(void *instance);
bool Radar(void *instance) {
    if (radar) {
        return true;
    }
    return old_Radar(instance);
}

bool (*old_Flash)(void *instance);
bool Flash(void *instance) {
    if (flash) {
        return true;
    }
    return old_Flash(instance);
}

bool (*old_MoneyHack)(void *instance);
bool MoneyHack(void *instance) {
    if (money) {
        return true;
    }
    return old_MoneyHack(instance);
}

void (*old_FovHack1)(void *instance, float fov);
void FovHack1(void *instance, float fov) {
    if (instance != NULL) {
        if (fovFeature) {
            fov = fovValue;
        }
    }
    old_FovHack1(instance, fov);
}

float (*old_FovHack2)(void *instance);
float FovHack2(void *instance) {
    if (instance != NULL) {
        if (fovFeature) {
            return fovValue;
        }
    }
    return old_FovHack2(instance);
}

void (*old_SetHealth1)(void *instance, float health);
void SetHealth1(void *instance, float health) {
    if (instance != NULL) {
        if (healthFeature) {
            health = healthValue;
        }
    }
    old_SetHealth1(instance, health);
}

float (*old_SetHealth2)(void *instance);
float SetHealth2(void *instance) {
    if (instance != NULL) {
        if (healthFeature) {
            return healthValue;
        }
    }
    return old_SetHealth2(instance);
}

int (*old_FireRate)(void *instance);
int FireRate(void *instance) {
    if (fireRate) {
        return 99999;
    }
    return old_FireRate(instance);
}

bool (*old_Ammo)(void *instance);
bool Ammo(void *instance) {
    if (ammo) {
        return true;
    }
    return old_Ammo(instance);
}

void *hack_thread(void *) {
	
	
	
    // ---------- Hook ---------- //
	hexPatches.Kik1 = MemoryPatch::createWithHex("libil2cpp.so", 0x1B4DB8C, "1E FF 2F E1");
    hexPatches.Kik1.Modify();
    hexPatches.Kik2 = MemoryPatch::createWithHex("libil2cpp.so", 0x92AFAC, "1E FF 2F E1");
    hexPatches.Kik2.Modify();
    hexPatches.Kik3 = MemoryPatch::createWithHex("libil2cpp.so", 0x92B044, "1E FF 2F E1");
    hexPatches.Kik3.Modify();
    hexPatches.Kik4 = MemoryPatch::createWithHex("libil2cpp.so", 0x92B18C, "1E FF 2F E1");
    hexPatches.Kik4.Modify();
    hexPatches.Kik5 = MemoryPatch::createWithHex("libil2cpp.so", 0x92B224, "1E FF 2F E1");
    hexPatches.Kik5.Modify();
    hexPatches.Kik6 = MemoryPatch::createWithHex("libil2cpp.so", 0x1B4DA1C, "1E FF 2F E1");
    hexPatches.Kik6.Modify(); 
    hexPatches.Kik7 = MemoryPatch::createWithHex("libil2cpp.so", 0x1B4DAEC, "1E FF 2F E1");
    hexPatches.Kik7.Modify(); 
    hexPatches.Kik8 = MemoryPatch::createWithHex("libil2cpp.so", 0x1B4DB14, "1E FF 2F E1");
    hexPatches.Kik8.Modify(); 
    hexPatches.Kik9 = MemoryPatch::createWithHex("libil2cpp.so", 0x1B4DB3C, "1E FF 2F E1");
    hexPatches.Kik9.Modify();
    hexPatches.Kik10 = MemoryPatch::createWithHex("libil2cpp.so", 0x1B4DB64, "1E FF 2F E1");
    hexPatches.Kik10.Modify();
	
	hexPatches.Defuse = MemoryPatch::createWithHex("libil2cpp.so", 0xE8D580, "01 00 A0 E3 1E FF 2F E1");
    hexPatches.Respawn = MemoryPatch::createWithHex("libil2cpp.so", 0x1215F4C, "01 00 A0 E3 1E FF 2F E1");
	hexPatches.Move = MemoryPatch::createWithHex("libil2cpp.so", 0x125C2BC, "01 00 A0 E3 1E FF 2F E1");
	hexPatches.Dont = MemoryPatch::createWithHex("libil2cpp.so", 0x1215F4C, "01 00 A0 E3 1E FF 2F E1");
	hexPatches.Buy = MemoryPatch::createWithHex("libil2cpp.so", 0x14BD4FC, "01 00 A0 E3 1E FF 2F E1");
	hexPatches.Plant = MemoryPatch::createWithHex("libil2cpp.so", 0x162ECC0, "01 00 A0 E3 1E FF 2F E1");
    hexPatches.Noclip = MemoryPatch::createWithHex("libil2cpp.so", 0xE6117C, "00 00 A0 E3 1E FF 2F E1");
    hexPatches.FireRate = MemoryPatch::createWithHex(libName, 0x1207E60, "00 00 A0 E3");
	hexPatches.InfAmmo = MemoryPatch::createWithHex("libil2cpp.so", 0x15EFE04, "00 00 A0 E3 1E FF 2F E1");
	
	WEAPON = (void (*)(void*, int)) getAbsoluteAddress(libName, 0x120C720);
	MSHookFunction((void *) getAbsoluteAddress(libName, 0x121211C), (void *) GAMEUPDATE, (void **) &old_GAMEUPDATE);
	
	GLOVES = (void (*)(void*, int)) getAbsoluteAddress("libil2cpp.so", 0xF01BA0);
    MSHookFunction((void *) getAbsoluteAddress("libil2cpp.so", 0xF036B4), (void *) GAMEUPDATE1, (void **) &old_GAMEUPDATE1);
	
	MSHookFunction((void *)getAbsoluteAddress("libil2cpp.so", 0x1789C5C), (void *) GameMode_Update, (void **) &old_GameMode_Update);
	MSHookFunction((void *) getAbsoluteAddress(libName, 0xF0E5BC), (void *) Radar, (void **) &old_Radar);
	MSHookFunction((void *) getAbsoluteAddress(libName, 0x14B7A80), (void *) MoneyHack, (void **) &old_MoneyHack);
	MSHookFunction((void *) getAbsoluteAddress(libName, 0x13F5480), (void *) Flash, (void **) &old_Flash);
	MSHookFunction((void *) getAbsoluteAddress("libil2cpp.so", 0xEFC9AC), (void *) Ping, (void **) &old_Ping);
	MSHookFunction((void *) getAbsoluteAddress(libName, 0x15EFE04), (void *) Ammo, (void **) &old_Ammo);
	
	MSHookFunction((void *) getAbsoluteAddress("libil2cpp.so", 0x178B9E8), (void *) LongHack,
                   (void **) &old_LongHack);

MSHookFunction((void *) getAbsoluteAddress("libil2cpp.so", 0xCEC618), (void *) FovHack1,
                   (void **) &old_FovHack1);//done
       
    MSHookFunction((void *) getAbsoluteAddress("libil2cpp.so", 0xCEC5AC), (void *) FovHack2,
                   (void **) &old_FovHack2);//done

MSHookFunction((void *) getAbsoluteAddress("libil2cpp.so", 0xEFCAF0), (void *) SetHealth1,
                   (void **) &old_SetHealth1);//done
       
    MSHookFunction((void *) getAbsoluteAddress("libil2cpp.so", 0xF012BC), (void *) SetHealth2,
                   (void **) &old_SetHealth2);//done


				   
 hexPatches.Recoil = MemoryPatch::createWithHex(libName, 0x15EFE04, "1EFF2FE1");//Отдача
 hexPatches.Spread = MemoryPatch::createWithHex(libName, 0x1D94DD0, "00000000");//разброс
 hexPatches.AimLegit = MemoryPatch::createWithHex("libunity.so", 0x6231D8, "0000403F");
 hexPatches.AimMedium = MemoryPatch::createWithHex("libunity.so", 0x6231D8, "A4707D3F");
 hexPatches.AimHigh = MemoryPatch::createWithHex("libunity.so", 0x6231D8, "6666A63F");
	
    return NULL;
}

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *globalEnv;
    vm->GetEnv((void **) &globalEnv, JNI_VERSION_1_6);

    // Create a new thread so it does not block the main thread, means the game would not freeze
    pthread_t ptid;
    pthread_create(&ptid, NULL, hack_thread, NULL);

    return JNI_VERSION_1_6;
}

JNIEXPORT void JNICALL
JNI_OnUnload(JavaVM *vm, void *reserved) {}
