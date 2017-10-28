## 全局网络请求模块

* OKhttp使用方法

1.   get请求

    String url = "http://www.csdn.net/";
    OkHttpUtils
        .get()
        .url(url)
        .addParams("username", "hyman")
        .addParams("password", "123")
        .build()
        .execute(new StringCallback(){
                    @Override
                    public void onError(Request request, Exception e){
                    }
                    @Override
                    public void onResponse(String response)
                    {
                    }
                });

 
              
2.    POST请求
       
     OkHttpUtils
            .post()
            .url(url)
            .addParams("username", "hyman")
            .addParams("password", "123")
            .build()
            .execute(callback);    
                
3.    Post String
  
     OkHttpUtils
      .postString()
      .url(url)
      .content(new Gson().toJson(new User("zhy", "123")))
      .build()
      .execute(new MyStringCallback()); 
      
      
4.    Post File
  
     OkHttpUtils
      .postFile()
      .url(url)
      .file(file)
      .build()
      .execute(new MyStringCallback());    
        
        
5.   基于POST的文件上传（类似web上的表单）
  
    OkHttpUtils.post()//
      .addFile("mFile", "messenger_01.png", file)//
      .addFile("mFile", "test1.txt", file2)//
      .url(url)
      .params(params)//
      .headers(headers)//
      .build()//
      .execute(new MyStringCallback());  
            
6.    下载文件
  
     OkHttpUtils//
      .get()//
      .url(url)//
      .build()//
      .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "gson-2.2.1.jar")//
      {
          @Override
          public void inProgress(float progress)
          {
              mProgressBar.setProgress((int) (100 * progress));
          }
  
          @Override
          public void onError(Request request, Exception e)
          {
              Log.e(TAG, "onError :" + e.getMessage());
          }
  
          @Override
          public void onResponse(File file)
          {
              Log.e(TAG, "onResponse :" + file.getAbsolutePath());
          }
      });    
              
7    显示图片
  
     OkHttpUtils
      .get()//
      .url(url)//
      .build()//
      .execute(new BitmapCallback()
      {
          @Override
          public void onError(Request request, Exception e)
          {
              mTv.setText("onError:" + e.getMessage());
          }
  
          @Override
          public void onResponse(Bitmap bitmap)
          {
              mImageView.setImageBitmap(bitmap);
          }
      });
      
8.   配置方法：

    （1）全局配置
    可以在Application中，通过：

     OkHttpClient client = 
     OkHttpUtils.getInstance().getOkHttpClient();

    然后调用client的各种set方法。

    例如：

     client.setConnectTimeout(100000, TimeUnit.MILLISECONDS);
    （2）为单个请求设置超时

    比如涉及到文件的需要设置读写等待时间多一点。

     OkHttpUtils
    .get()//
    .url(url)//
    .tag(this)//
    .build()//
    .connTimeOut(20000)
    .readTimeOut(20000)
    .writeTimeOut(20000)
    .execute()

    调用build()之后，可以随即设置各种timeOut.

    （3）取消单个请求

     RequestCall call = OkHttpUtils.get().url(url).build();
    call.cancel();
    （4）根据tag取消请求

    目前对于支持的方法都添加了最后一个参数Object tag，取消则通过OkHttpUtils.cancelTag(tag)执行。

    例如：在Activity中，当Activity销毁取消请求：

    OkHttpUtils
    .get()//
    .url(url)//
    .tag(this)//
    .build()//

    @Override
    protected void onDestroy()
    {
    super.onDestroy();
    //可以取消同一个tag的
    OkHttpUtils.cancelTag(this);//取消以Activity.this作为tag的请求
    }