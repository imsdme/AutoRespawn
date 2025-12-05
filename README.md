<img width="2722" height="1169" alt="preview" src="https://github.com/user-attachments/assets/7ded36f5-077a-41c3-9b63-93bbf6685aa9" />

**AutoRespawn** is a lightweight plugin that allows to fully customize and automate the process of a player returning to the game after death.

## Features
> **Instant Respawn with Delay:**
- Fully configurable delay in seconds (respawn-delay), allowing you to control the pace of the game.

> **Advanced Color and Formatting System:**
- Full compatibility with HEX Codes (&#RRGGBB).
- Support for MiniMessage syntax (<red>message), ensuring the highest quality formatting.

> **Customizable Respawn Effects:**
- Titles: Display custom main and sub-titles.
- Sounds: Play any Minecraft sound (sounds.sound) to accompany the respawn.
- Particles: Trigger your chosen particle effect (particles.effect) at the player's spawn - location.
 
> **Ease of Management:**
- Easily enable/disable any of the above effects via the config.yml file.
- Manage the plugin using a reload command to apply configuration changes without stopping the server.

## Commands
| Command             | Description           |
|---------------------|:---------------------:|
| `/autorespawn reload` | Reloads the plugin's configuration. |

## Permissions
| Permission             | Description           | Default |
|---------------------|:---------------------:|:---------------------:|
| `autorespawn.reload` | Allows reloading the plugin with `/autorespawn reload`. | `op` |

## Configuration

| Parameter  | Description  |
|---------------------|:---------------------:|
| `respawn-delay` | The delay in seconds before the player is automatically respawned. |
| `titles.enabled` | Enable or disable the display of titles upon respawn. |
| `titles.main` | The Main Title displayed to the player. Supports HEX codes and MiniMessage formatting. |
| `titles.sub` | The SubTitle displayed beneath the main title. Supports HEX codes and MiniMessage. | `op` |
| `sounds.enabled` | Enable or disable the playing of a sound upon respawn. |
| `sounds.sound` | The name of the Minecraft sound to be played. |
| `particles.enabled` | Enable or disable the display of particles upon respawn. |
| `particles.effect` | The name of the particle effect to be displayed. |

## Where can I find the sound or particle names?

> Sound:
  
<img width="507" height="65" alt="find_sound" src="https://github.com/user-attachments/assets/e907c95e-cafc-49b0-8836-1458d77d8655" />

> Particle:

<img width="367" height="62" alt="find_particle" src="https://github.com/user-attachments/assets/ccb90248-8fc7-42f1-93fe-e6231038c43e" />
