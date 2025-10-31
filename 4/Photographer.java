
// 機能限定版

interface Photo {
  void TakePhoto();
}

class Cellular implements Photo {
  public void MakeCall() {
    System.out.println("携帯電話で電話を掛けました．");
  }

  public void TakePhoto() {
    System.out.println("携帯電話で写真を撮りました．");
  }
}

class Camera implements Photo {
  public void TakePhoto() {
    System.out.println("デジカメで写真を撮りました．");
  }
}

class VideoCam implements Photo {
  public void RecordMovie() {
    System.out.println("ビデオカメラで動画を撮影しました．");
  }

  public void TakePhoto() {
    System.out.println("ビデオカメラで写真を撮りました．");
  }
}

class Android implements Photo {
  public void MakeCall() {
    System.out.println("スマホで電話を掛けました．");
  }

  public void BrowseWeb() {
    System.out.println("スマホでネットを見ました．");
  }

  public void TakePhoto() {
    System.out.println("スマホで写真を撮りました．");
  }
}

class Photographer {
  final static int MAX = 20; // final static int は定数の定義です．
  private Photo camera[] = new Photo[MAX];
  private int num = 0;

  public void add(Photo p) {
    if (num >= MAX)
      return;
    camera[num++] = p;
  }

  public void TakeAll() {
    for (int i = 0; i < num; i++) {
      System.out.print("[" + (i + 1) + "] ");
      camera[i].TakePhoto();
    }
  }

  public static void main(String argv[]) {
    Photographer p = new Photographer();
    for (int i = 0; i < MAX; i++) {
      int r = (int) (Math.random() * 4);
      switch (r) {
        case 0:
          p.add(new Cellular());
          break;
        case 1:
          p.add(new Camera());
          break;
        case 2:
          p.add(new VideoCam());
          break;
        case 3:
          p.add(new Android());
          break;
      }
    }
    p.TakeAll();
  }
}
