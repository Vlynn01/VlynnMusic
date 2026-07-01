package com.vlynn.music.di

import com.vlynn.music.viewModel.AlbumViewModel
import com.vlynn.music.viewModel.AnalyticsViewModel
import com.vlynn.music.viewModel.ArtistViewModel
import com.vlynn.music.viewModel.HomeViewModel
import com.vlynn.music.viewModel.LibraryDynamicPlaylistViewModel
import com.vlynn.music.viewModel.LibraryViewModel
import com.vlynn.music.viewModel.LocalPlaylistViewModel
import com.vlynn.music.viewModel.LogInViewModel
import com.vlynn.music.viewModel.MoodViewModel
import com.vlynn.music.viewModel.MoreAlbumsViewModel
import com.vlynn.music.viewModel.NotificationViewModel
import com.vlynn.music.viewModel.NowPlayingBottomSheetViewModel
import com.vlynn.music.viewModel.PlaylistViewModel
import com.vlynn.music.viewModel.PodcastViewModel
import com.vlynn.music.viewModel.RecentlySongsViewModel
import com.vlynn.music.viewModel.SearchViewModel
import com.vlynn.music.viewModel.SettingsViewModel
import com.vlynn.music.viewModel.SharedViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =
    module {
        single {
            SharedViewModel(
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
            )
        }
        single {
            SearchViewModel(
                get(),
                get(),
            )
        }
        viewModel {
            NowPlayingBottomSheetViewModel(
                get(),
                get(),
                get(),
                get(),
            )
        }
        viewModel {
            LibraryViewModel(
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
            )
        }
        viewModel {
            LibraryDynamicPlaylistViewModel(
                get(),
                get(),
            )
        }
        viewModel {
            AlbumViewModel(
                get(),
                get(),
            )
        }
        viewModel {
            HomeViewModel(
                get(),
                get(),
            )
        }
        viewModel {
            SettingsViewModel(
                get(),
                get(),
                get(),
                get(),
                get(),
            )
        }
        viewModel {
            ArtistViewModel(
                get(),
                get(),
                get(),
            )
        }
        viewModel {
            PlaylistViewModel(
                get(),
                get(),
                get(),
            )
        }
        viewModel {
            LogInViewModel(
                get(),
            )
        }
        viewModel {
            PodcastViewModel(
                get(),
            )
        }
        viewModel {
            MoreAlbumsViewModel(
                get(),
            )
        }
        viewModel {
            RecentlySongsViewModel(
                get(),
            )
        }
        viewModel {
            LocalPlaylistViewModel(
                get(),
                get(),
                get(),
            )
        }
        viewModel {
            NotificationViewModel(
                get(),
            )
        }
        viewModel {
            MoodViewModel(
                get(),
                get(),
            )
        }
        viewModel {
            AnalyticsViewModel(
                get(),
                get(),
                get(),
                get(),
                get(),
            )
        }
    }