package com.dhkim.common

enum class Genre(val id: Int, val genre: String) {
    ACTION(28, "액션"),
    ADVENTURE(12, "어드벤처"),
    ANIMATION(16, "애니메이션"),
    COMEDY(35, "코미디"),
    CRIME(80, "범죄"),
    DOCUMENTARY(99, "다큐멘터리"),
    DRAMA(18, "드라마"),
    FAMILY(10751, "가족"),
    FANTASY(14, "판타지"),
    HISTORY(36, "역사"),
    HORROR(27, "공포"),
    MUSIC(10402, "음악"),
    MYSTERY(9648, "미스테리"),
    ROMANCE(10749, "로맨스"),
    SCIENCE_FICTION(878, "SF"),
    TV_MOVIE(10770, "TV 영화"),
    THRILLER(53, "스릴러"),
    WAR(10752, "전쟁"),
    WESTERN(37, "서부"),
    ACTION_ADVENTURE(10759, "액션 & 어드벤처"),
    KIDS(10762, "키즈"),
    NEWS(10763, "뉴스"),
    REALITY(10764, "리얼리티"),
    SCI_FI_FANTASY(10765, "SF & 판타지"),
    SOAP(10766, "연속극"),
    TALK(10767, "토크쇼"),
    WAR_POLITICS(10768, "전쟁 & 정치"),
    Unknown(-1, "알 수 없음");

    companion object {
        fun seriesGenre(id: Int): Genre? = entries.find { it.id == id }
    }
}