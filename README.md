# Dailymlb
- 메이저리그(Major League Baseball) 경기결과, 팀 순위, 개인 순위를 확인할 수 있는 Android 앱 입니다.
*데이터는 실제와 다를 수 있습니다.

### 기술 및 개발환경
<div>
  <img src="https://img.shields.io/badge/Android-blue?logo=Android">
  <img src="https://img.shields.io/badge/Java-6DB33F?">
  <img src="https://img.shields.io/badge/Android_Studio-sky_blue?logo=Android Studio">
</div>

외부 API
- [Sportsdata.io](https://sportsdata.io/developers/api-documentation/mlb)

### 프로젝트 구조
- MVP Paterrn, Singletone Paterrn
```sh
app
 ┣ src
 ┃ ┣ androidTest
 ┃ ┃ ┗ java
 ┃ ┃ ┃ ┗ com
 ┃ ┃ ┃ ┃ ┗ jmp
 ┃ ┃ ┃ ┃ ┃ ┗ dailymlb
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ ExampleInstrumentedTest.java
 ┃ ┣ main
 ┃ ┃ ┣ java
 ┃ ┃ ┃ ┗ com
 ┃ ┃ ┃ ┃ ┗ jmp
 ┃ ┃ ┃ ┃ ┃ ┗ dailymlb
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ iface
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ APIService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ OnClickResultListener.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ Constants.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ Game.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ GameReviewWrapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ GameStatus.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ Inning.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ Play.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ PlayByPlay.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ PlayerStat.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ Retrofit2Client.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ ScoreBoard.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ Stadium.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ Standing.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ Team.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ TeamStat.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ Teams.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ presenter
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ GameReviewContract.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ GameReviewPresenter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ GamesContract.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ GamesPresenter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ MainContract.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ MainPresenter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ PlayerRankContract.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ PlayerRankPresenter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ TeamRankContract.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ TeamRankPresenter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ view
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ GameReviewActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ GameReviewInningAdapter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ GameReviewStatisticsAdapter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ GamesAdapter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ GamesByDateFragment.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ MainActivity.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ PlayerRankAdapter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ PlayerRankFragment.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ TeamRankDivisionAdapter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ TeamRankFragment.java
 ┃ ┃ ┣ res
 ┃ ┃ ┃ ┣ drawable
 ┃ ┃ ┃ ┃ ┣ ari.png
 ┃ ┃ ┃ ┃ ┣ atl.png
 ┃ ┃ ┃ ┃ ┣ bal.png
 ┃ ┃ ┃ ┃ ┣ blank.png
 ┃ ┃ ┃ ┃ ┣ border.xml
 ┃ ┃ ┃ ┃ ┣ bos.png
 ┃ ┃ ┃ ┃ ┣ chc.png
 ┃ ┃ ┃ ┃ ┣ chw.png
 ┃ ┃ ┃ ┃ ┣ cin.png
 ┃ ┃ ┃ ┃ ┣ cle.png
 ┃ ┃ ┃ ┃ ┣ col.png
 ┃ ┃ ┃ ┃ ┣ det.png
 ┃ ┃ ┃ ┃ ┣ hide.png
 ┃ ┃ ┃ ┃ ┣ hou.png
 ┃ ┃ ┃ ┃ ┣ ic_launcher_background.xml
 ┃ ┃ ┃ ┃ ┣ kc.png
 ┃ ┃ ┃ ┃ ┣ laa.png
 ┃ ┃ ┃ ┃ ┣ lad.png
 ┃ ┃ ┃ ┃ ┣ mia.png
 ┃ ┃ ┃ ┃ ┣ mil.png
 ┃ ┃ ┃ ┃ ┣ min.png
 ┃ ┃ ┃ ┃ ┣ nym.png
 ┃ ┃ ┃ ┃ ┣ nyy.png
 ┃ ┃ ┃ ┃ ┣ oak.png
 ┃ ┃ ┃ ┃ ┣ phi.png
 ┃ ┃ ┃ ┃ ┣ pit.png
 ┃ ┃ ┃ ┃ ┣ review.png
 ┃ ┃ ┃ ┃ ┣ sd.png
 ┃ ┃ ┃ ┃ ┣ sea.png
 ┃ ┃ ┃ ┃ ┣ sf.png
 ┃ ┃ ┃ ┃ ┣ stl.png
 ┃ ┃ ┃ ┃ ┣ tb.png
 ┃ ┃ ┃ ┃ ┣ tex.png
 ┃ ┃ ┃ ┃ ┣ tor.png
 ┃ ┃ ┃ ┃ ┣ visible.png
 ┃ ┃ ┃ ┃ ┗ wsh.png
 ┃ ┃ ┃ ┣ drawable-v24
 ┃ ┃ ┃ ┃ ┗ ic_launcher_foreground.xml
 ┃ ┃ ┃ ┣ layout
 ┃ ┃ ┃ ┃ ┣ activity_game_review.xml
 ┃ ┃ ┃ ┃ ┣ activity_main.xml
 ┃ ┃ ┃ ┃ ┣ fragment_game_review.xml
 ┃ ┃ ┃ ┃ ┣ fragment_games_by_date.xml
 ┃ ┃ ┃ ┃ ┣ fragment_season_player_rank.xml
 ┃ ┃ ┃ ┃ ┣ fragment_team_season_rank.xml
 ┃ ┃ ┃ ┃ ┣ item_games.xml
 ┃ ┃ ┃ ┃ ┣ item_player_rank.xml
 ┃ ┃ ┃ ┃ ┣ item_review.xml
 ┃ ┃ ┃ ┃ ┗ item_team_rank.xml
 ┃ ┃ ┃ ┣ menu
 ┃ ┃ ┃ ┃ ┗ menu_bottom.xml
 ┃ ┃ ┃ ┣ mipmap-anydpi-v26
 ┃ ┃ ┃ ┃ ┣ ic_launcher.xml
 ┃ ┃ ┃ ┃ ┗ ic_launcher_round.xml
 ┃ ┃ ┃ ┣ mipmap-hdpi
 ┃ ┃ ┃ ┃ ┣ ic_launcher.png
 ┃ ┃ ┃ ┃ ┗ ic_launcher_round.png
 ┃ ┃ ┃ ┣ mipmap-mdpi
 ┃ ┃ ┃ ┃ ┣ ic_launcher.png
 ┃ ┃ ┃ ┃ ┗ ic_launcher_round.png
 ┃ ┃ ┃ ┣ mipmap-xhdpi
 ┃ ┃ ┃ ┃ ┣ ic_launcher.png
 ┃ ┃ ┃ ┃ ┗ ic_launcher_round.png
 ┃ ┃ ┃ ┣ mipmap-xxhdpi
 ┃ ┃ ┃ ┃ ┣ ic_launcher.png
 ┃ ┃ ┃ ┃ ┗ ic_launcher_round.png
 ┃ ┃ ┃ ┣ mipmap-xxxhdpi
 ┃ ┃ ┃ ┃ ┣ ic_launcher.png
 ┃ ┃ ┃ ┃ ┗ ic_launcher_round.png
 ┃ ┃ ┃ ┗ values
 ┃ ┃ ┃ ┃ ┣ colors.xml
 ┃ ┃ ┃ ┃ ┣ strings.xml
 ┃ ┃ ┃ ┃ ┗ styles.xml
 ┃ ┃ ┗ AndroidManifest.xml
 ┃ ┗ test
 ┃ ┃ ┗ java
 ┃ ┃ ┃ ┗ com
 ┃ ┃ ┃ ┃ ┗ jmp
 ┃ ┃ ┃ ┃ ┃ ┗ dailymlb
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ ExampleUnitTest.java
 ┣ .gitignore
 ┣ build.gradle
 ┗ proguard-rules.pro
```

### 라이브러리
- Retrofit2: HTTP Method Client
- Gson: Rest API 데이터를 Json Object 로 변환

### 화면설계

|Home & 경기상세기록|팀 순위|개인 순위|
|---|---|---|
|![list-detail](https://github.com/jmp7911/Dailymlb/assets/37658328/b578d913-c2aa-4703-bc84-607390e3d765)|![standings](https://github.com/jmp7911/Dailymlb/assets/37658328/62f64b0f-fe76-4fd5-914f-b687e15f1fef)|![personal-rank](https://github.com/jmp7911/Dailymlb/assets/37658328/c3e48b8e-8239-47d3-8f8f-2beb58c9196b)|

### 회고
- MVP Pattern
  - ![다운로드](https://github.com/jmp7911/Dailymlb/assets/37658328/428cb3a5-1399-41ec-8afe-6868e80b52d9) 
  - Model, View 는 의존성이 없어 유지보수에 장점이 있습니다. View는 Model을 가지지 않으며 Presenter를 통해서 데이터가 전달 됩니다.
  - 다만 View, Presenter 의 의존성은 어플리케이션이 복잡해 질 수록 의존성이 강해집니다.

- Singletone Pattern
  - 전역으로 사용하는 객체의 생성자는 오직 1개의 객체만 생성하고 참조해야 합니다.
  - Java 에서는 클래스 내에 static 으로 자신을 참조하고, 
 
    생성자는 private로 다른 곳에서의 생성을 못하도록 하여 getInstance()메소드를 통해서만 참조하도록 구현합니다.

- RecyclerView
  - Android View 이며 많은 데이터를 List에 넣을 수 있습니다.
  - ListView는 스크롤이 될 때 객체를 생성하고 삭제하기를 반복하는 반면,
 
    RecyclerView는 객체를 삭제하지 않고 재사용하여 성능이 더 좋습니다.
  - Presenter의 역할을 하는 Adapter를 구현해야 합니다.
  - Model의 역할을 하는 ViewHolder를 구현해야 합니다.
  
