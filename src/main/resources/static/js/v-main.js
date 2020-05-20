var messageApi=Vue.resource('/history/{id}');

Vue.component('message-row',{
    props:['message'],
   template: '<div><i>({{ message.date }})</i> {{ message.client.name }}</div>'
});
Vue.component('messages-list', {
    props:['mes'],
    template: '<div><message-row v-for="message in mes"  :key="message.id"  :message="message" /></div>',
    created:function(){
        messageApi.get().then(result=>
            result.json().then(
                data=>data.forEach(message=>this.mes.push(message))
            )
        )
    }
});

var app = new Vue({
    el: '#app',
    template: '<messages-list :mes="messages" />',
    data: {
        messages: [
         /*   { id: '0', text: 'Овощи' },
            { id: '1', text: 'Сыр' },
            { id: '2', text: 'Что там ещё люди едят?' }*/
        ]
        // show:true
    }
});