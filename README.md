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
### 기능명세


### 화면설계

