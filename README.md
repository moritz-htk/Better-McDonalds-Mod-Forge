<p align="center">
    <img src="https://i.imgur.com/3Fk3R5m.png"  alt="Better McDonald's Mod Logo"/>
</p>

[![CurseForge Downloads](https://cf.way2muchnoise.eu/short_546816_downloads.svg?badge_style=for_the_badge)](https://www.curseforge.com/minecraft/mc-mods/better-mcdonalds-mod)
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/kdnePgr1?style=for-the-badge&logo=modrinth)](https://modrinth.com/mod/better-mcdonalds-mod)
![Mod Version](https://img.shields.io/modrinth/v/kdnePgr1?style=for-the-badge)
[![License](https://img.shields.io/badge/LICENSE-moritz__htk_Software_License_Agreement_(mSLA)-red?style=for-the-badge)](https://sites.google.com/view/moritz-htk/license)

The Better McDonald's Mod was created by [moritz_htk](https://github.com/moritz-htk). Many well-known products have been added such as:
- Big Mac
- Happy Meal
- Coca-Cola

...and more! To prepare the food, a new cooking utensil and new ingredients were added. You can find salt blocks in rivers and extract salt from them. Seeds for tomato and lettuce plants are obtained from grass or fern.

> **NOTE**:  Support for Forge is expected to be discontinued during 2024.

## Latest versions
|                   | Fabric | Forge  | NeoForge |
|-------------------|--------|--------|----------|
| Minecraft Version | 1.20.4 | 1.20.4 | 1.20.4   |
| Mod Version       | 3.2.0  | 3.2.0  | 3.2.0    |

Click [here](https://github.com/moritz-htk/Better-McDonalds-Mod-Forge/releases) to get to the release list!

## Supported languages
- Dutch, English, French, German, Italian, Japanese, Portuguese, Russian, Spanish, Ukrainian

## Planned functions
- configuration screen
- machines for manufacturing
- side mod (McCafé, Grimace Shake, Shamrock Shake)

## Credits
- [Volwert123](https://github.com/Volwert123/) (Contributor)
- [RPorotos](https://www.fiverr.com/rporotos) (Textures)
- [kohari_nk](https://www.fiverr.com/kohari_nk) (Textures)
- [sovseabird](https://www.fiverr.com/sovseabird) (Textures)

## Dependencies
- [Cloth Config API](https://github.com/shedaniel/cloth-config) (v13.0.121 and above)

## Maven
Better McDonald's Mod is  available via [Curse Maven](https://www.cursemaven.com/) for developers wishing to make use of my mod.

Update your `build.gradle` file to include the following:

```
repositories {
    maven { url "https://cursemaven.com" }
}

dependencies {
    implementation fg.deobf("curse.maven:better-mcdonalds-mod-546816:${bettermcdonaldsmod_file}")
}
```

Add the following to your `gradle.properties` file:

```
bettermcdonaldsmod_file=4996715
```

To get the File ID, go to the [download page of the file](https://www.curseforge.com/minecraft/mc-mods/better-mcdonalds-mod/files/4996715) you want to use, and the file ID will be in the URL.

Ensure to include this in your `mods.toml` file:

```
[[dependencies.modid]]
    modId="bettermcdonaldsmod"
    mandatory=true
    versionRange="[1.20.4-3.2.0,)"
    ordering="NONE"
    side="BOTH"
```

## Social Media
Website: [https://sites.google.com/view/moritz-htk](https://sites.google.com/view/moritz-htk)

---
> **NOTE**:  This is an unofficial modification and is not affiliated with McDonald's Corporation.