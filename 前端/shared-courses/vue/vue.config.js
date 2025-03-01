const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
      devServer: {
    port:1000
},
  chainWebpack: config =>{
    config.plugin('html')
        .tap(args => {
          args[0].title = "共享课程";
          return args;
        })
  }
})
