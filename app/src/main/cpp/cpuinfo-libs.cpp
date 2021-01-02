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
Java_com_example_androidprofiler_generate_1data_model_provider_CpuNativeProvider_initLibrary(
        JNIEnv *env, jobject thiz) {
    if (!cpuinfo_initialize()) {
        LOGI("Error during initialization");
    }
}


extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_androidprofiler_generate_1data_model_provider_CpuNativeProvider_getCpuName(
        JNIEnv *env, jobject thiz) {
    if (!cpuinfo_initialize()) {
        return env->NewStringUTF("not initialize");
    }
    return env->NewStringUTF(cpuinfo_get_package(0)->name);
}


extern "C"
JNIEXPORT jintArray JNICALL
Java_com_example_androidprofiler_generate_1data_model_provider_CpuNativeProvider_getL1Caches(
        JNIEnv *env, jobject thiz) {
    if (!cpuinfo_initialize() || cpuinfo_get_l1d_caches_count() == 0) {
        return nullptr;
    }

    uint32_t cacheCount = cpuinfo_get_l1d_caches_count();
    jintArray result = env->NewIntArray(cacheCount);
    jint internalArray[cacheCount];
    auto l1dCaches = cpuinfo_get_l1d_caches();
    for (uint32_t i = 0; i < cacheCount; i++) {
        internalArray[i] = l1dCaches[i].size;
    }
    env->SetIntArrayRegion(result, 0, cacheCount, internalArray);
    return result;
}


extern "C"
JNIEXPORT jintArray JNICALL
Java_com_example_androidprofiler_generate_1data_model_provider_CpuNativeProvider_getL2Caches(
        JNIEnv *env, jobject thiz) {
    if (!cpuinfo_initialize() || cpuinfo_get_l1i_caches_count() == 0) {
        return nullptr;
    }

    uint32_t cacheCount = cpuinfo_get_l1i_caches_count();
    jintArray result = env->NewIntArray(cacheCount);
    jint internalArray[cacheCount];
    auto l1iCaches = cpuinfo_get_l1i_caches();
    for (uint32_t i = 0; i < cacheCount; i++) {
        internalArray[i] = l1iCaches[i].size;
    }
    env->SetIntArrayRegion(result, 0, cacheCount, internalArray);
    return result;
}


extern "C"
JNIEXPORT jintArray JNICALL
Java_com_example_androidprofiler_generate_1data_model_provider_CpuNativeProvider_getL3Caches(
        JNIEnv *env, jobject thiz) {
    if (!cpuinfo_initialize() || cpuinfo_get_l2_caches_count() == 0) {
        return nullptr;
    }

    uint32_t cacheCount = cpuinfo_get_l2_caches_count();
    jintArray result = env->NewIntArray(cacheCount);
    jint internalArray[cacheCount];
    auto l2Caches = cpuinfo_get_l2_caches();
    for (uint32_t i = 0; i < cacheCount; i++) {
        internalArray[i] = l2Caches[i].size;
    }
    env->SetIntArrayRegion(result, 0, cacheCount, internalArray);
    return result;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_com_example_androidprofiler_generate_1data_model_provider_CpuNativeProvider_getL4Caches(
        JNIEnv *env, jobject thiz) {
    if (!cpuinfo_initialize() || cpuinfo_get_l3_caches_count() == 0) {
        return nullptr;
    }

    uint32_t cacheCount = cpuinfo_get_l3_caches_count();
    jintArray result = env->NewIntArray(cacheCount);
    jint internalArray[cacheCount];
    auto l3Caches = cpuinfo_get_l3_caches();
    for (uint32_t i = 0; i < cacheCount; i++) {
        internalArray[i] = l3Caches[i].size;
    }
    env->SetIntArrayRegion(result, 0, cacheCount, internalArray);
    return result;
}