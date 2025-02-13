workspace {
    !identifiers hierarchical

    model {
        user = person "Пользователь" "Турист, использующий бота для поиска информации о достопримечательностях."
        system = softwareSystem "Система" {
            s = container "Сервер"
            n = container "Нейросеть" "Определяет достопримечательность по картинке"
            data = container "База данных" "Список всех достопримечательностей, информация о пользователях"{
                tags "data"
            }
            bot = container "Веб-интерфейс" "Телеграмм бот"


        }
        user -> system.bot "Регистрация"
        user -> system.bot "Включает уведомления"
        user -> system.bot "Загружает картинку"
        user -> system.bot "Запрос на взаимодействие с рейтингом"
        user -> system.bot "Добавляет человека в друзья"
        user -> system.bot "Делится достопримечательностью с другом"
        system.bot -> user "Уведомление о мероприятии"

        system.s -> system.data "Запись нового пользователя"
        system.s -> system.data "Редактирование информации о месте/пользователе"
        system.bot -> system.s "Запрос на добавление/изменение информации достопримечательности"
        system.bot -> system.s "Запрос на добавление/изменение информации пользователя"
        system.bot -> system.s "Запрос на обработку картинки"

        system.n -> system.s "Возвращает информацию о месте на картинке"
        system.s -> system.n "картинка с достопримечательностью"

    }

    views {
        container system "Diagram2" {
            include *
            autolayout lr
        }

        styles {
            element "Element" {
                color white
            }
            element "Person" {
                background #4B0082
                shape person
            }
            element "Container" {
                background #8A2BE2
            }
            element "data" {
                shape cylinder
            }
        }

    }

    configuration {
        scope softwaresystem
    }
}