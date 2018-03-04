const KotlinWebpackPlugin = require('kotlin-webpack-plugin');
const path = require('path');
module.exports = ({ platform }, { resolve, plugins }) => ({
  entry: `./kotlin_build/kotlinApp.js`,
  resolve: {
    ...resolve,
    // "kotlin_build" is where the compiled Kotlin code (kotlinApp.js) is outputted
    modules: ['node_modules', 'kotlin_build'],
  },
  // module: {
  //   rules: [
  //     {
  //       test: /\.js$/,
  //       include: path.resolve(__dirname, '../kotlin_build'),
  //       use: ['source-map-loader'],
  //       enforce: 'pre',
  //     },
  //   ],
  // },
  plugins: [
    ...plugins,
    new KotlinWebpackPlugin({
      src: __dirname + '/src',
      verbose: true,
      // optimize: true,
      libraries: [
        '@jetbrains/kotlin-extensions',
        '@jetbrains/kotlin-react',
      ].map(pkg => require.resolve(pkg)),
    }),
  ],
});
