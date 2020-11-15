#include <cstring>
#include <jni.h>
#include <cinttypes>
#include <android/log.h>
#include <string>
#include "../../../../external/cpuinfo/include/cpuinfo.h"

#define LOGI(...) \
  ((void)__android_log_print(ANDROID_LOG_INFO, "cpuinfo-libs::", __VA_ARGS__))

extern "C"
JNIEXPORT void JNICALL
Java_com_example_androidprofiler_cpu_model_provider_CpuNativeProvider_initLibrary(JNIEnv *env,
                                                                                  jobject thiz) {
    if (!cpuinfo_initialize()) {
        LOGI("Error during initialization");
    }
}

extern "C"
JNIEXPORT jstring JNICALL
        Java_com_example_androidprofiler_cpu_model_provider_CpuNativeProvider_getCpuName(JNIEnv *env,
                                                                                         jobject thiz) {
    if (!cpuinfo_initialize()) {
        return env->NewStringUTF("not initialize");
    }
    return env->NewStringUTF(cpuinfo_get_package(0)->name);
}
